package pages;

import helpers.ValidationMessageManager;
import io.qameta.allure.Step;
import helpers.UrlManager;
import helpers.UserManager;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.UrlManager.*;
import static helpers.UserManager.*;

public class LoginPage extends PageBase {

    @Step("Open Login page")
    public void openLoginPage() {
        open(BASEURL + LOGINPAGE);
        $(".outer-step").shouldHave(text("Welcome Back!"));
    }

    @Step("Fill 'Business Email' field")
    public void fillBusinessEmailField() {
        $("[data-test=email] [data-test=input]").setValue(BUSINESSEMAIL);
    }

    @Step("Fill 'Password' field")
    public void fillPasswordField() {
        $("[data-test=password] [data-test=input]").setValue(PASSWORD);
    }

    @Step("User logged to SimilarWeb successfully")
    public void checkSuccessfullLogin() {
        //TODO: Move variables to another file
        String marketResearch = "Digital Research Intelligence";

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
        $("[data-test=email]")
                .shouldHave(text(ValidationMessageManager.INVALIDEMAIL));
        $("[data-test=password]")
                .shouldHave(text(ValidationMessageManager.EMPTYPASSWORD));
    }

    @Step("Validate incorrect credentials for email/password fields")
    public void checkIncorrectCredentialValidation() {
        //TODO: Move variables to another file
        String incorrectEmailPassValidationMessage = "Username or password is incorrect";

        checkValidationInputField(
                BUSINESSEMAIL,
                INVALIDPASSWORD,
                ValidationMessageManager.INCORRECTEMAILPASSWORD);

        checkValidationInputField(
                INVALIDBUSINESSEMAIL,
                INVALIDPASSWORD,
                ValidationMessageManager.INCORRECTEMAILPASSWORD);

        checkValidationInputField(
                INVALIDBUSINESSEMAIL,
                INVALIDPASSWORD,
                ValidationMessageManager.INCORRECTEMAILPASSWORD);
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
        $("[data-test=forgotPasswordLink]").shouldHave(href("/" + FORGOTPASSWORD));
        $("[data-test=signUpLink]").shouldHave(href("/" + REGISTRATIONPAGE));
    }
}
