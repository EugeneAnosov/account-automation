package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

@DisplayName("Login Page")
public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("User Login Test")
    @Story("User logged to SimilarWeb successfully")
    void successfulLoginTest() {
        loginPage.openLoginPage();
        loginPage.fillForm();
        loginPage.checkSuccessfullLogin();
    }

    @Test
    @DisplayName("Fields Validation Test")
    @Story("Check input fields validation on the page")
    void loginPageValidationTest() {
        loginPage.openLoginPage();
        loginPage.submit();
        loginPage.checkEmptyFieldValidation();
        loginPage.checkIncorrectCredentialValidation();
    }

    @Test
    @DisplayName("Social Network Login Test")
    @Story("User logged to Similarweb via Social Network")
    void successfulGoSocialNetworkTest() {
        //TODO: Split the test and add full sign in flow
        loginPage.openLoginPage();
        loginPage.openGoogleAuthorizationPage();

        loginPage.openLoginPage();
        loginPage.openLinkedinAuthorizationPage();
    }

    @Test
    @DisplayName("Login Page Links Test")
    @Story("Check links on the page")
    void assertLinksTest() {
        loginPage.openLoginPage();
        loginPage.assertLoginPageLink();
    }
}
