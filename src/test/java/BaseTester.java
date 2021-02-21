import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTester {

    String baseUrl = "https://moster-account.sandbox.similarweb.com/";

    String loginPage = "login";
    String forgotPasswordPage = "forgotpassword";
    String registrationPage = "registration";
    String legalPage = "corp/legal/terms";
    String privacyPolicy = "corp/legal/privacy-policy/";

    public void openLoginPage() {
        open(baseUrl + loginPage);
        $(".outer-step__title").shouldHave(text("Welcome Back!"));
    }

    public void openForgotPasswordPage() {
        open(baseUrl + forgotPasswordPage);
        $(".outer-step__group--header").shouldHave(text("Password Reset"));
    }

    public void openRegistrationPage() {
        open(baseUrl + registrationPage);
        $(".outer-step__title").shouldHave(text("Create your account"));
    }
}
