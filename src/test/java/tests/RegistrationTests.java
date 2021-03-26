package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobjects.RegistrationPage;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeEach


    @Test
    public void userRegistrationTest() {

        registrationPage.openLoginPage();
        registrationPage.fillForm();
    }

    @Test
    public void registrationPageValidationTest() {

        registrationPage.openLoginPage();
        registrationPage.submit();
        registrationPage.checkEmptyFieldValidation();
        registrationPage.checkFirstNameValidation();
        registrationPage.checkLastNameValidation();
        registrationPage.checkExistingEmailValidation();
        //registrationPage.checkGmailEmailValidation();
        registrationPage.checkInvalidPasswordValidation();
    }

    @Test
    public void checkLanguageChooser() {

        registrationPage.openLoginPage();
        registrationPage.chooseJapanLanguage();
        registrationPage.chooseFranceLanguage();
        registrationPage.choosePortugalLanguage();
    }

    @Test
    public void assertLinks() {

        registrationPage.openLoginPage();
        registrationPage.assertRegistrationPageLink();
    }
}
