package pageobjects;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class ForgotPasswordPage extends PageBase {

    public void openForgotPasswordPage() {
        urlManager.openForgotPasswordPage();
    }

    public void clickRecaptcha() {

        //TODO: Turn off a ReCaptcha
        switchTo().frame($x("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"));
        $("div.rc-anchor-content").click();
        switchTo().defaultContent();
    }
}
