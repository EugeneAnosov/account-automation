import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    String BaseUrl = "https://freeze-account.sandbox.similarweb.com/";

    String loginPage = "login";
    String forgotPasswordPage = "forgotpassword";

    public void openLoginPage() {
        open(BaseUrl + loginPage);
        $(".outer-step__title").shouldHave(text("Welcome Back!"));
    }

    public void openForgotPasswordPage() {
        open(BaseUrl + forgotPasswordPage);
        $(".outer-step__group--header").shouldHave(text("Password Reset"));
    }
}
