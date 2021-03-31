package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ForgotPasswordPage;

@DisplayName("Forgot Password Page")
public class ForgotPasswordTests extends TestBase {

    @Test
    @DisplayName("Forgot Password Page Test")
    @Story("Open page and click by Recaptcha")
    void checkForgotPasswordTest() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.clickRecaptcha();
    }
}
