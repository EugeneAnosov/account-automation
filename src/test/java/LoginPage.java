import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    String validEmail = "yevhen.anosov+automation@similarweb.com";
    String invalidEmail = "yevhen.anosov+automation1@similarweb.com";

    String validPassword = "Qwerty1";
    String invalidPassword = "Qwerty11";

    @Test
    public void loginUser() {
        openLoginPage();

        $(byName("username")).setValue(validEmail);
        $(byName("password")).setValue(validPassword).pressEnter();

        sleep(10000);

        $(byAttribute("data-automation", "Title")).shouldHave(text("Market Research"));
    }

    @Test
    public void loginPageValidation() {
        openLoginPage();

        $(byText("log in")).click();
        $(".outer-step__form-line").shouldHave(text("Please enter valid Email"));
        $(".outer-step__form-line:nth-child(2)").shouldHave(text("Please enter Password"));

        $(byName("username")).setValue(invalidEmail);
        $(byName("password")).setValue("Qwerty1").pressEnter();
        $(".outer-step__group--error").shouldHave(text("Username or password is incorrect"));

        $(byName("username")).setValue(invalidEmail);
        $(byName("password")).setValue(invalidPassword).pressEnter();
        $(".outer-step__group--error").shouldHave(text("Username or password is incorrect"));
    }

    @Test
    public void loginSocialNetwork() {
        openLoginPage();

        $(".social-auth__button--google").click();
        $("#yDmH0d").shouldHave(text("Google"));

        openLoginPage();

        $(".social-auth__button--linkedin").click();
        $(".footer-app-content-actions").shouldHave(text("New to LinkedIn?"));
    }

    @Test
    public void assertLinks() {
        openLoginPage();

        $(".outer-step__link-blue").shouldHave(href("/forgotpassword"));
        $(".outer-step__group:nth-child(6) > p > a").shouldHave(href("/registration"));
    }
}
