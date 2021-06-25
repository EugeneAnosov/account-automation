package pages;

import helpers.UrlManager;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class ForgotPasswordPage extends PageBase {

    @Step("Open 'Forgot Password' page")
    public void openForgotPasswordPage() {
        open(UrlManager.BASEURL + UrlManager.FORGOTPASSWORD);
        $(".outer-step__group--header").shouldHave(text("Password Reset"));
    }

    @Step("Click by Recaptcha")
    public void clickRecaptcha() {

        //TODO: Turn off a ReCaptcha
        switchTo().frame($x("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"));
        $("div.rc-anchor-content").click();
        switchTo().defaultContent();
    }
}
