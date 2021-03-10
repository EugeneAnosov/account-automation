package tests;

import manager.UrlManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationTester extends BaseTester {

    @Test
    public void signUpUser() {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String validEmail = "yevhen.anosov+automation" + timeStamp + "@similarweb.com";
        String validPassword = "Qwerty1";

        openRegistrationPage();

        $(By.name("firstName")).setValue("test");
        $(By.name("lastName")).setValue("automationSignUp");
        $(By.name("email")).setValue(validEmail);
        $(By.name("password")).setValue(validPassword).pressEnter();
        $(".outer-step__button-primary").click();

        $(".outer-step__title").shouldHave(text("Confirm your email address"));
    }

    @Test
    public void checkValidation() {

        String existingEmail = "yevhen.anosov+automation@similarweb.com";
        String gmailEmail = "eugene.anosov+automation@gmail.com";
        String invalidPassword = "1";

        openRegistrationPage();

        $(".outer-step__button-primary").pressEnter();

        $(".outer-step__form-column").shouldHave(text("Please enter first name"));
        $("div:nth-child(2) > .swui-error--in").shouldHave(text("Please enter last name"));
        $("div:nth-child(2) > div >.swui-error--in").shouldHave(text("Please enter valid Email"));
        $("div:nth-child(3) > div >.swui-error--in").shouldHave(text("Please enter password"));

        $(By.name("firstName")).setValue("222").pressTab();
        $("div > .swui-error--in").shouldHave(text("Please enter valid first name"));

        $(By.name("lastName")).setValue("222").pressTab();
        $("div:nth-child(2) > .swui-error--in").shouldHave(text("Please enter valid last name"));

        $(By.name("email")).setValue(existingEmail).pressTab();
        $("div:nth-child(2) > div >.swui-error--in").shouldHave(text("A user name for that e-mail address already exists. Please enter a different e-mail address."));

        $(By.name("email")).clear();
        $(By.name("email")).setValue(gmailEmail).pressTab();
        $("div:nth-child(2) > div >.swui-error--in").shouldHave(text("If you want to sign up with Gmail please use the Google Button"));

        $(By.name("password")).pressEnter();
        $("div:nth-child(3) > div >.swui-error--in").shouldHave(text("Please enter password"));

        $(By.name("password")).setValue(invalidPassword).pressEnter();
        $("div:nth-child(3) > div >.swui-error--in").shouldHave(text("Password must be at least 6 characters long"));
    }

    @Test
    public void checkLanguageChooser() {

        openRegistrationPage();

        $(".us").click();
        $(".jp").click();
        $(".outer-step__title").shouldHave(text("アカウントを作成する"));

        $(".jp").click();
        $(".fr").click();
        $(".outer-step__title").shouldHave(text("Créer votre compte"));

        $(".fr").click();
        $(".pt").click();
        $(".outer-step__title").shouldHave(text("Crie sua conta"));
    }

    @Test
    public void assertLinks() {

        String loginAssertlink = "/login?returnUrl=https://moster-pro.sandbox.similarweb.com";
        String ninjaSandbox = "https://www.similarweb.ninja//";

        openRegistrationPage();

        $(".outer-step__link-blue").shouldHave(href(loginAssertlink));
        $(".legal__link").shouldHave(href(ninjaSandbox + UrlManager.Url.LEGALPAGE.getUrl()));
        $(".legal__link:nth-child(2)").shouldHave(href(ninjaSandbox + UrlManager.Url.PRIVACYPOLICY.getUrl()));
    }
}
