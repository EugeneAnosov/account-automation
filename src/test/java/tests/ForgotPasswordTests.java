package tests;

import org.junit.jupiter.api.Test;
import pageobjects.ForgotPasswordPage;

public class ForgotPasswordTests extends TestBase {

    @Test
    void checkForgotPasswordTest() {

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.clickRecaptcha();
    }
}
