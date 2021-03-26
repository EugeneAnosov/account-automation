package tests;

import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;

public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    void successfulLoginTest() {

        loginPage.openLoginPage();
        loginPage.fillForm();
        loginPage.checkSuccessfullLogin();
    }

    @Test
    void loginPageValidationTest() {

        loginPage.openLoginPage();
        loginPage.submit();
        loginPage.checkEmptyFieldValidation();
        loginPage.checkIncorrectCredentialValidation();
    }

    @Test
    void successfulGoSocialNetworkTest() {

        //TODO: Split the test and add full sign in flow

        loginPage.openLoginPage();
        loginPage.openGoogleAuthorizationPage();

        loginPage.openLoginPage();
        loginPage.openLinkedinAuthorizationPage();
    }

    @Test
    void assertLinksTest() {

        loginPage.openLoginPage();
        loginPage.assertLoginPageLink();
    }
}
