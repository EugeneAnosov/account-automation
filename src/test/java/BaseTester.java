import manager.UrlManager;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTester {

    public void openLoginPage() {
        open(UrlManager.Url.BASEURL.getUrl() + UrlManager.Url.LOGINPAGE.getUrl());
        $(".outer-step__title").shouldHave(text("Welcome Back!"));
    }

    public void openForgotPasswordPage() {
        open(UrlManager.Url.BASEURL.getUrl() + UrlManager.Url.FORGOTPASSWORD.getUrl());
        $(".outer-step__group--header").shouldHave(text("Password Reset"));
    }

    public void openRegistrationPage() {
        open(UrlManager.Url.BASEURL.getUrl() + UrlManager.Url.REGISTRATIONPAGE.getUrl());
        $(".outer-step__title").shouldHave(text("Create your account"));
    }
}
