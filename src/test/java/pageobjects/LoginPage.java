package pageobjects;

import managers.UrlManager;
import managers.UserManager;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends PageBase {

    public void openLoginPage() {
        urlManager.openLoginPage();
    }

    public void fillForm() {

        $("[data-test=email] [data-test=input]").setValue(UserManager.User.BUSINESSEMAIL.getUser());
        $("[data-test=password] [data-test=input]").setValue(UserManager.User.PASSWORD.getUser()).pressEnter();
    }

    public void checkSuccessfullLogin() {

        //TODO: Move variable to another file
        String marketResearch = "Market Research";

        $(".app-loader").shouldBe(visible);
        $(".app-loader").should(disappear, Duration.ofSeconds(30));
        $("[data-automation=Title]").shouldHave(text(marketResearch));
    }

    public void submit() {

        $("[data-test=submitButton]").click();
    }

    public void checkEmptyFieldValidation() {

        //TODO: Move variables to another file
        String invalidEmailValidationMessage = "Please enter valid Email";
        String emptyPasswordValidationMessage = "Please enter Password";

        $("[data-test=email]")
                .shouldHave(text(invalidEmailValidationMessage));
        $("[data-test=password]")
                .shouldHave(text(emptyPasswordValidationMessage));
    }

    public void checkIncorrectCredentialValidation() {

        //TODO: Move variable to another file
        String incorrectEmailPassValidationMessage = "Username or password is incorrect";

        checkValidationInputField(
                UserManager.User.BUSINESSEMAIL.getUser(),
                UserManager.User.INVALIDPASSWORD.getUser(),
                incorrectEmailPassValidationMessage);

        checkValidationInputField(
                UserManager.User.INVALIDBUSINESSEMAIL.getUser(),
                UserManager.User.PASSWORD.getUser(),
                incorrectEmailPassValidationMessage);

        checkValidationInputField(
                UserManager.User.INVALIDBUSINESSEMAIL.getUser(),
                UserManager.User.INVALIDPASSWORD.getUser(),
                incorrectEmailPassValidationMessage);
    }

    private void checkValidationInputField(String businessEmail, String password, String validationMessage) {

        $("[data-test=email] [data-test=input]").setValue(businessEmail);
        $("[data-test=password] [data-test=input]").setValue(password).pressEnter();

        // Add I18N keys support
        $("[data-test=error]").shouldHave(text(validationMessage));
    }

    public void openGoogleAuthorizationPage() {

        String google = "Google";
        $("[data-test=googleButton]").click();
        $("#initialView").shouldHave(text(google));
    }

    public void openLinkedinAuthorizationPage() {

        String linkedin = "New to LinkedIn?";
        $("[data-test=linkedinButton]").click();
        $("#app__container").shouldHave(text(linkedin));
    }

    public void assertLoginPageLink() {
        $("[data-test=forgotPasswordLink]").shouldHave(href("/" + UrlManager.Url.FORGOTPASSWORD.getUrl()));
        $("[data-test=signUpLink]").shouldHave(href("/" + UrlManager.Url.REGISTRATIONPAGE.getUrl()));
    }
}
