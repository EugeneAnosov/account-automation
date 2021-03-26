package managers;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UrlManager {

    public enum Url {
        BASEURL("https://moster-account.sandbox.similarweb.com/"),
        LOGINPAGE("login"),
        FORGOTPASSWORD("forgotpassword"),
        REGISTRATIONPAGE("registration"),
        LEGALPAGE("corp/legal/terms"),
        PRIVACYPOLICY("corp/legal/privacy-policy/");

        private String url;

        Url(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    public void openLoginPage() {
        open(UrlManager.Url.BASEURL.getUrl() + UrlManager.Url.LOGINPAGE.getUrl());
        $(".outer-step").shouldHave(text("Welcome Back!"));
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
