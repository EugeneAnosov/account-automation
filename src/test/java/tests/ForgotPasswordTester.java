package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class ForgotPasswordTester extends BaseTester {

    @Test
    public void checkForgotPasswordTest() {

        openForgotPasswordPage();

        switchTo().frame($x("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"));
        $("div.rc-anchor-content").click();
        switchTo().defaultContent();

        //Turn-off a ReCaptcha
    }
}
