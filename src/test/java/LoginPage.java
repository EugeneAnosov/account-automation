import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    @Test
    public void loginUser() {
        open("https://freeze-account.sandbox.similarweb.com/login");
        $(".outer-step__title").shouldHave(text("Welcome Back!"));

        $(byName("username")).setValue("yevhen.anosov+automation@similarweb.com");
        $(byName("password")).setValue("Qwerty1").pressEnter();

        sleep(10000);

        $(byAttribute("data-automation", "Title")).shouldHave(text("Market Research"));
    }

    @Test
    public void loginPageValidation() {
        open("https://freeze-account.sandbox.similarweb.com/login");
        $(".outer-step__title").shouldHave(text("Welcome Back!"));

        $(byText("log in")).click();
        $(".outer-step__form-line").shouldHave(text("Please enter valid Email"));
        $(".outer-step__form-line:nth-child(2)").shouldHave(text("Please enter Password"));

        $(byName("username")).setValue("yevhen.anosov+automation1@similarweb.com");
        $(byName("password")).setValue("Qwerty1").pressEnter();
        $(".outer-step__group--error").shouldHave(text("Username or password is incorrect"));

        $(byName("username")).setValue("yevhen.anosov+automation1@similarweb.com");
        $(byName("password")).setValue("Qwerty11").pressEnter();
        $(".outer-step__group--error").shouldHave(text("Username or password is incorrect"));
    }

    @Test
    public void loginSocialNetwork() {
        open("https://freeze-account.sandbox.similarweb.com/login");
        $(".outer-step__title").shouldHave(text("Welcome Back!"));

        $(".social-auth__button--google").click();
        $("#yDmH0d").shouldHave(text("Google"));

        open("https://freeze-account.sandbox.similarweb.com/login");
        $(".outer-step__title").shouldHave(text("Welcome Back!"));

        $(".social-auth__button--linkedin").click();
        $(".footer-app-content-actions").shouldHave(text("New to LinkedIn?"));
    }

    @Test
    public void assertLinks() {
        open("https://freeze-account.sandbox.similarweb.com/login");
        $(".outer-step__title").shouldHave(text("Welcome Back!"));

        $(".outer-step__link-blue").shouldHave(href("/forgotpassword"));
        $(".outer-step__group:nth-child(6) > p > a").shouldHave(href("/registration"));
    }
}
