package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@DisplayName("Registration Page")
public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    @DisplayName("User Registration Test")
    @Story("User registered successfully")
    public void userRegistrationTest() {
        registrationPage.openRegistrationPage();
        registrationPage.fillForm();
        registrationPage.submit();
        registrationPage.checkConfirmationPageOpened();
    }

    @Test
    @DisplayName("Fields Validation Test")
    @Story("Fields validation on the Registration page")
    public void registrationPageValidationTest() {
        registrationPage.openRegistrationPage();
        registrationPage.submit();
        registrationPage.checkEmptyFieldValidation();
        registrationPage.checkFirstNameValidation();
        registrationPage.checkLastNameValidation();
        registrationPage.checkExistingEmailValidation();
        registrationPage.checkInvalidPasswordValidation();
    }

    @Test
    @DisplayName("Fields GMAIL Validation Test")
    @Story("Gmail email validation on the Registration page")
    public void registrationGmailEmailValidationTest() {
        registrationPage.openRegistrationPage();
        registrationPage.checkGmailEmailValidation();
    }

    @Test
    @DisplayName("Language Chooser Test")
    @Story("Check languages in the dropdown")
    public void checkLanguageChooser() {
        registrationPage.openRegistrationPage();
        registrationPage.chooseJapanLanguage();
        registrationPage.chooseFranceLanguage();
        registrationPage.choosePortugalLanguage();
    }

    @Test
    @DisplayName("Registration Page Links Test")
    @Story("Check links on the page")
    public void assertLinks() {
        registrationPage.openRegistrationPage();
        registrationPage.assertRegistrationPageLink();
    }
}
