package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;
import static helpers.UrlManager.BASEURL;
import static helpers.UrlManager.FORGOTPASSWORD;

public class ForgotPasswordPage extends PageBase {

    @Step("Open 'Forgot Password' page")
    public void openForgotPasswordPage() {
        String assertForgotPasswordPage = "Password Reset";

        open(BASEURL + FORGOTPASSWORD);
        $(".outer-step__group--header").shouldHave(text(assertForgotPasswordPage));
    }

    @Step("Click by Recaptcha")
    public void clickRecaptcha() {

        //TODO: Turn off a ReCaptcha
        switchTo().frame($x("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"));
        $("div.rc-anchor-content").click();
        switchTo().defaultContent();
    }
}
