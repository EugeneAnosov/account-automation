import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTester {

    @Test
    public void successfulLoginTest() {

        String marketResearch = "Market Research";

        UrlManager loginPage = new UrlManager();
        loginPage.openLoginPage();

        UserManager user = new UserManager();

        $(byName("username")).setValue(user.businessEmail);
        $(byName("password")).setValue(user.password).pressEnter();
        sleep(10000);

        $(byAttribute("data-automation", "Title")).shouldHave(text(marketResearch));
    }

    @Test
    public void loginPageValidationTest() {

        String incorrectEmailPassValidationMessage = "Username or password is incorrect";
        String invalidEmailValidationMessage = "Please enter valid Email";
        String emptyPasswordValidationMessage = "Please enter Password";

        UrlManager loginPage = new UrlManager();
        loginPage.openLoginPage();

        $(".outer-step__button-primary").click();
        $(".outer-step__form-line").shouldHave(text(invalidEmailValidationMessage));
        $(".outer-step__form-line:nth-child(2)").shouldHave(text(emptyPasswordValidationMessage));

        UserManager user = new UserManager();

        checkValidationInputField(user.businessEmail, user.invalidPassword, incorrectEmailPassValidationMessage);
        checkValidationInputField(user.invalidBusinessEmail, user.password, incorrectEmailPassValidationMessage);
        checkValidationInputField(user.invalidBusinessEmail, user.invalidPassword, incorrectEmailPassValidationMessage);
    }

    private void checkValidationInputField(String businessEmail, String password, String validationMessage) {

        $(byName("username")).setValue(businessEmail);
        $(byName("password")).setValue(password).pressEnter();
        $(".outer-step__group--error").shouldHave(text(validationMessage));
    }

    @Test
    public void successfulGoSocialNetworkTest() {

        String google = "Google";
        String linkedin = "New to LinkedIn?";

        UrlManager loginPage = new UrlManager();
        loginPage.openLoginPage();

        $(".social-auth__button--google").click();
        $("#yDmH0d").shouldHave(text(google));

        loginPage.openLoginPage();

        $(".social-auth__button--linkedin").click();
        $(".footer-app-content-actions").shouldHave(text(linkedin));
    }

    @Test
    public void assertLinksTest() {
        UrlManager loginPage = new UrlManager();
        loginPage.openLoginPage();

        $(".outer-step__link-blue").shouldHave(href("/" + UrlManager.Url.FORGOTPASSWORD.getUrl()));
        $(".outer-step__group:nth-child(6) > p > a").shouldHave(href("/" + UrlManager.Url.REGISTRATIONPAGE.getUrl()));
    }
}
