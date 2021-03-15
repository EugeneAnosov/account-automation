package tests;

import manager.UrlManager;
import manager.UserManager;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTester extends BaseTester {

    @Test
    public void successfulLoginTest() {

        String marketResearch = "Market Research";

        openLoginPage();

        $(byName("username")).setValue(UserManager.User.BUSINESSEMAIL.getUser());
        $(byName("password")).setValue(UserManager.User.PASSWORD.getUser()).pressEnter();

        sleep(10000); // Replace to wait.until()

        $(byAttribute("data-automation", "Title")).shouldHave(text(marketResearch));
    }

    @Test
    public void loginPageValidationTest() {

        String incorrectEmailPassValidationMessage = "Username or password is incorrect";
        String invalidEmailValidationMessage = "Please enter valid Email";
        String emptyPasswordValidationMessage = "Please enter Password";

        openLoginPage();

        $(byAttribute("data-test", "submit-login")).click();
        $(byAttribute("data-test", "email"))
                .shouldHave(text(invalidEmailValidationMessage));
        $(byAttribute("data-test", "password"))
                .shouldHave(text(emptyPasswordValidationMessage));

        checkValidationInputField(UserManager.User.BUSINESSEMAIL.getUser(),
                UserManager.User.INVALIDPASSWORD.getUser(), incorrectEmailPassValidationMessage);
        checkValidationInputField(UserManager.User.INVALIDBUSINESSEMAIL.getUser(),
                UserManager.User.PASSWORD.getUser(), incorrectEmailPassValidationMessage);
        checkValidationInputField(UserManager.User.INVALIDBUSINESSEMAIL.getUser(),
                UserManager.User.INVALIDPASSWORD.getUser(), incorrectEmailPassValidationMessage);
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

        openLoginPage();

        $(byAttribute("data-test", "google")).click();
        $(".kHn9Lb").shouldHave(text(google));

        openLoginPage();

        $(byAttribute("data-test", "linkedin")).click();
        $(".footer-app-content-actions").shouldHave(text(linkedin));
    }

    @Test
    public void assertLinksTest() {

        openLoginPage();

        $(byAttribute("data-test", "forgot-password")).shouldHave(href("/" + UrlManager.Url.FORGOTPASSWORD.getUrl()));
        $(byAttribute("data-test", "sign-up")).shouldHave(href("/" + UrlManager.Url.REGISTRATIONPAGE.getUrl()));
    }
}
