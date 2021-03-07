import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UrlManager {

    enum Url{
        BASEURL("https://moster-account.sandbox.similarweb.com/"),
        LOGINPAGE("login"),
        FORGOTPASSWORD("forgotpassword"),
        REGISTRATIONPAGE("registration"),
        LEGALPAGE("corp/legal/terms"),
        PRIVACYPOLICY("corp/legal/privacy-policy/");

        private String url;

        Url(String url){
            this.url = url;
        }

        public String getUrl(){return url;}
        }

    public void openLoginPage() {
        open(Url.BASEURL.getUrl() + Url.LOGINPAGE.getUrl());
        $(".outer-step__title").shouldHave(text("Welcome Back!"));
    }

    public void openForgotPasswordPage() {
        open(Url.BASEURL.getUrl() + Url.FORGOTPASSWORD.getUrl());
        $(".outer-step__group--header").shouldHave(text("Password Reset"));
    }

    public void openRegistrationPage() {
        open(Url.BASEURL.getUrl() + Url.REGISTRATIONPAGE.getUrl());
        $(".outer-step__title").shouldHave(text("Create your account"));
    }

}
