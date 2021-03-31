package pages;

import io.qameta.allure.Step;
import managers.UrlManager;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends PageBase {

    @Step("Open Registration page")
    public void openRegistrationPage() {
        urlManager.openRegistrationPage();
    }

    @Step("User fills form")
    public void fillForm() {
        //TODO: Move variables to another file
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String validEmail = "yevhen.anosov+automation" + timeStamp + "@similarweb.com";
        String validPassword = "Qwerty1";

        $("[data-test=firstName] [data-test=input]").setValue("test");
        $("[data-test=lastName] [data-test=input]").setValue("automationSignUp");
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
        $("#app").shouldHave(text("Confirm your email address"));
    }

    @Step("Check empty fields validation")
    public void checkEmptyFieldValidation() {
        $("[data-test=firstName] [data-test=error]").shouldHave(text("Please enter first name"));
        $("[data-test=lastName] [data-test=error]").shouldHave(text("Please enter last name"));
        $("[data-test=email] [data-test=error]").shouldHave(text("Please enter valid Email"));
        $("[data-test=password] [data-test=error]").shouldHave(text("Please enter password"));
    }

    @Step("Check 'First Name' validation")
    public void checkFirstNameValidation() {
        $("[data-test=firstName] [data-test=input]").setValue("222").pressTab();
        $("[data-test=firstName] [data-test=error]").shouldHave(text("Please enter valid first name"));
    }

    @Step("Check 'Last Name' validation")
    public void checkLastNameValidation() {
        $("[data-test=lastName] [data-test=input]").setValue("222").pressTab();
        $("[data-test=lastName] [data-test=error]").shouldHave(text("Please enter valid last name"));
    }

    @Step("Validation of existing email")
    public void checkExistingEmailValidation() {
        //TODO: Move variables to another file
        String existingEmail = "yevhen.anosov+automation@similarweb.com";

        $("[data-test=email] [data-test=input]").setValue(existingEmail).pressTab();
        $("[data-test=email] [data-test=error]")
                .shouldHave(text("A user name for that e-mail address already exists. Please enter a different e-mail address."));
    }

    @Step("Password 'must be at least 6 characters' validation")
    public void checkInvalidPasswordValidation() {
        //TODO: Move variable to another file
        String invalidPassword = "1";

        $("[data-test=password] [data-test=input]").setValue(invalidPassword).pressTab();
        $("[data-test=password] [data-test=error]").shouldHave(text("Password must be at least 6 characters long"));
    }

    @Step("Gmail user cannot sign up validation")
    public void checkGmailEmailValidation() {
        //TODO: Move variable to another file
        String gmailEmail = "test@gmail.com";

        // TODO: FIX. Cannot navigate to input focus
        $("[data-test=email] [data-test=input]").setValue(gmailEmail).pressTab();
        $("[data-test=email] [data-test=error]").shouldHave(text("If you want to sign up with Gmail please use the Google Button"));
    }

    @Step("Choose Japanese language")
    public void chooseJapanLanguage() {
        $("[data-test=select]").click();
        $(".jp").click();
        $(".outer-step__title").shouldHave(text("アカウントを作成する"));
    }

    @Step("Choose French language")
    public void chooseFranceLanguage() {
        $(".jp").click();
        $(".fr").click();
        $(".outer-step__title").shouldHave(text("Créer votre compte"));
    }

    @Step("Choose Portugal language")
    public void choosePortugalLanguage() {
        $(".fr").click();
        $(".pt").click();
        $(".outer-step__title").shouldHave(text("Crie sua conta"));
    }

    @Step("Check links on the page")
    public void assertRegistrationPageLink() {

        //TODO: Move variable to another file
        String loginLink = "/login?returnUrl=https://moster-pro.sandbox.similarweb.com";
        String stagingLiteSandbox = "https://staging-lite.sandbox.similarweb.com/";

        $("[data-test=loginLink]").shouldHave(href(loginLink));
        $("[data-test=termsLink]").shouldHave(href(stagingLiteSandbox + UrlManager.Url.LEGALPAGE.getUrl()));
        $("[data-test=privacyLink]").shouldHave(href(stagingLiteSandbox + UrlManager.Url.PRIVACYPOLICY.getUrl()));
    }
}
