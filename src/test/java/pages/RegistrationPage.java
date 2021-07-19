package pages;

import com.codeborne.selenide.Selenide;
import helpers.ValidationMessageManager;
import io.qameta.allure.Step;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.UrlManager.*;

public class RegistrationPage extends PageBase {

    @Step("Open Registration page")
    public void openRegistrationPage() {
        String assertSignUpPage = "Create your account";

        open(BASEURL + REGISTRATIONPAGE);
        $(".outer-step__title").shouldHave(text(assertSignUpPage));
    }

    @Step("User fills form")
    public void fillForm() {
        //TODO: Move variables to another file
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String validEmail = "yevhen.anosov+automation" + timeStamp + "@similarweb.com";
        String validPassword = "Qwerty1";

        String firstName = "test";
        String lastName = "automationSignUp";

        $("[data-test=firstName] [data-test=input]").setValue(firstName);
        $("[data-test=lastName] [data-test=input]").setValue(lastName);
        $("[data-test=email] [data-test=input]").setValue(validEmail);
        $("[data-test=password] [data-test=input]").setValue(validPassword).pressEnter();
    }

    @Step("Click by SignUp button")
    public void submit() {
        $("[data-test=submitButton]").click();
    }

    @Step("Check that confirmation page is opened")
    public void checkConfirmationPageOpened() {
        //TODO: Add I18N keys support
        String assertConfirmationPage = "Confirm your email address";

        $("#app").shouldHave(text(assertConfirmationPage));
    }

    @Step("Check empty fields validation")
    public void checkEmptyFieldValidation() {
        $("[data-test=firstName] [data-test=error]").shouldHave(text(ValidationMessageManager.EMPTYFIRSTNAME));
        $("[data-test=lastName] [data-test=error]").shouldHave(text(ValidationMessageManager.EMPTYLASTNAME));
        $("[data-test=email] [data-test=error]").shouldHave(text(ValidationMessageManager.INVALIDEMAIL));
        $("[data-test=password] [data-test=error]").shouldHave(text(ValidationMessageManager.EMPTYPASSWORD));
    }

    @Step("Check 'First Name' validation")
    public void checkFirstNameValidation() {
        String invalidFirstName = "111";

        $("[data-test=firstName] [data-test=input]").setValue(invalidFirstName).pressTab();
        $("[data-test=firstName] [data-test=error]").shouldHave(text(ValidationMessageManager.INVALIDFIRSTNAME));
    }

    @Step("Check 'Last Name' validation")
    public void checkLastNameValidation() {
        String invalidLastName = "222";

        $("[data-test=lastName] [data-test=input]").setValue(invalidLastName).pressTab();
        $("[data-test=lastName] [data-test=error]").shouldHave(text(ValidationMessageManager.INVALIDLASTNAME));
    }

    @Step("Validation of existing email")
    public void checkExistingEmailValidation() {
        //TODO: Move variables to another file
        String existingEmail = "yevhen.anosov+automation@similarweb.com";

        $("[data-test=email] [data-test=input]").setValue(existingEmail).pressTab();
        $("[data-test=email] [data-test=error]")
                .shouldHave(text(ValidationMessageManager.EXISTINGEMAIL));
    }

    @Step("Password 'must be at least 6 characters' validation")
    public void checkInvalidPasswordValidation() {
        //TODO: Move variables to another file
        String invalidPassword = "1";


        $("[data-test=password] [data-test=input]").setValue(invalidPassword).pressTab();
        $("[data-test=password] [data-test=error]").shouldHave(text(ValidationMessageManager.INVALIDSHORTPASSWORD));
    }

    @Step("Gmail user cannot sign up validation")
    public void checkGmailEmailValidation() {
        //TODO: Move variables to another file
        String gmailEmail = "test@gmail.com";

        $("[data-test=email] [data-test=input]").setValue(gmailEmail).pressTab();
        $("[data-test=email] [data-test=error]").shouldHave(text(ValidationMessageManager.GOOGLEVALIDATION));
    }

    @Step("Choose Japanese language")
    public void chooseJapanLanguage() {
        String assertJapanLanguage = "アカウントを作成する";

        $("[data-test=select]").click();
        $(".jp").click();
        $(".outer-step__title").shouldHave(text(assertJapanLanguage));
    }

    @Step("Choose French language")
    public void chooseFranceLanguage() {
        String assertFranceLanguage = "Créer votre compte";

        $(".jp").click();
        $(".fr").click();
        $(".outer-step__title").shouldHave(text(assertFranceLanguage));
    }

    @Step("Choose Portugal language")
    public void choosePortugalLanguage() {
        String assertPortugalLanguage = "Crie sua conta";

        $(".fr").click();
        $(".pt").click();
        $(".outer-step__title").shouldHave(text(assertPortugalLanguage));
    }

    @Step("Check links on the page")
    public void assertRegistrationPageLink() {

        //TODO: Move variables to another file
        String loginLink = "/login?returnUrl=https://moster-pro.sandbox.similarweb.com";
        String stagingLiteSandbox = "https://staging-lite.sandbox.similarweb.com/";

        $("[data-test=loginLink]").shouldHave(href(loginLink));
        $("[data-test=termsLink]").shouldHave(href(stagingLiteSandbox + LEGALPAGE));
        $("[data-test=privacyLink]").shouldHave(href(stagingLiteSandbox + PRIVACYPOLICY));
    }
}
