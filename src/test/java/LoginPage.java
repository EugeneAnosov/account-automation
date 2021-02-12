import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    @Test
    public void loginUser() {
        open("https://moster-account.sandbox.similarweb.com/login");
        $(".outer-step__title").shouldHave(text("Welcome Back!"));

        $(byName("username")).setValue("yevhen.anosov+automation@similarweb.com");
        $(byName("password")).setValue("Qwerty1").pressEnter();

        sleep(10000);

        $(byAttribute("data-automation", "Title")).shouldHave(text("Market Research"));
    }

    @Test
    public void loginPageValidation() {
        open("https://moster-account.sandbox.similarweb.com/login");
        $(".outer-step__title").shouldHave(text("Welcome Back!"));


    }
}
