import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageObject extends BasePageObject {

    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    String validEmail = "yevhen.anosov+automation" + timeStamp + "@similarweb.com";
    String existingEmail = "yevhen.anosov+automation@similarweb.com";

    String validPassword = "Qwerty1";
    String invalidPassword = "1";

    String loginReturnUrlParameter = "/login?returnUrl=";

    @Test
    public void signUpUser() {
        openRegistrationPage();

        $(By.name("firstName")).setValue("test");
        $(By.name("lastName")).setValue("automationSignUp");
        $(By.name("email")).setValue(validEmail);
        $(By.name("password")).setValue(validPassword).pressEnter();

        $(".outer-step__title").shouldHave(text("Confirm your email address"));
    }

    @Test
    public void checkValidation() {
        openRegistrationPage();

        $(".outer-step__button-primary").pressEnter();

        $(".swui-error--in").shouldHave(text("Please enter first name"));
        $(".swui-error--in:nth-child(1)").shouldHave(text("Please enter last name"));
        $(".swui-error--in:nth-child(2)").shouldHave(text("Please enter valid Email"));
        $(".swui-error--in:nth-child(3)").shouldHave(text("Please enter password"));

        $(By.name("firstName")).setValue("222");
        $(".swui-error--in").shouldHave(text("Please enter valid first name"));

        $(By.name("lastName")).setValue("222");
        $(".swui-error--in:nth-child(1)").shouldHave(text("Please enter valid last name"));

        $(By.name("email")).setValue(existingEmail);
        $(".swui-error--in:nth-child(2)").shouldHave(text("A user name for that e-mail address already exists. Please enter a different e-mail address."));

        $(By.name("password")).setValue(invalidPassword).pressEnter();
        $(".swui-error--in:nth-child(3)").shouldHave(text("Please enter password"));
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
        openRegistrationPage();

        $(".outer-step__link-blue").shouldHave(href(loginReturnUrlParameter + baseUrl));
        $(".legal__link").shouldHave(href(baseUrl + legalPage));
    }
}
