package pages;

import io.qameta.allure.Step;
import managers.UrlManager;
import managers.UserManager;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends PageBase {

    @Step("Open Login page")
    public void openLoginPage() {
        urlManager.openLoginPage();
    }

    @Step("Fill 'Business Email' and 'Password'")
    public void fillForm() {
        $("[data-test=email] [data-test=input]").setValue(UserManager.User.BUSINESSEMAIL.getUser());
        $("[data-test=password] [data-test=input]").setValue(UserManager.User.PASSWORD.getUser()).pressEnter();
    }

    @Step("User logged to SimilarWeb successfully")
    public void checkSuccessfullLogin() {
        //TODO: Move variable to another file
        String marketResearch = "Market Research";

        $(".app-loader").shouldBe(visible);
        $(".app-loader").should(disappear, Duration.ofSeconds(30));
        $("[data-automation=Title]").shouldHave(text(marketResearch));
    }

    @Step("Click to 'Continue' button")
    public void submit() {
        $("[data-test=submitButton]").click();
    }

    @Step("Check that empty field validation is correct")
    public void checkEmptyFieldValidation() {
        //TODO: Move variables to another file
        String invalidEmailValidationMessage = "Please enter valid Email";
        String emptyPasswordValidationMessage = "Please enter Password";

        $("[data-test=email]")
                .shouldHave(text(invalidEmailValidationMessage));
        $("[data-test=password]")
                .shouldHave(text(emptyPasswordValidationMessage));
    }

    @Step("Validate incorrect credentials for email/password fields")
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

    @Step("Open Google authorization page")
    public void openGoogleAuthorizationPage() {
        String google = "Google";
        $("[data-test=googleButton]").click();
        $("#initialView").shouldHave(text(google));
    }

    @Step("Open Linkedin authorization page")
    public void openLinkedinAuthorizationPage() {
        String linkedin = "New to LinkedIn?";
        $("[data-test=linkedinButton]").click();
        $("#app__container").shouldHave(text(linkedin));
    }

    @Step("Check that links are not empty")
    public void assertLoginPageLink() {
        $("[data-test=forgotPasswordLink]").shouldHave(href("/" + UrlManager.Url.FORGOTPASSWORD.getUrl()));
        $("[data-test=signUpLink]").shouldHave(href("/" + UrlManager.Url.REGISTRATIONPAGE.getUrl()));
    }
}
