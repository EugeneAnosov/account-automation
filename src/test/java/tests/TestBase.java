package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @BeforeEach
    public void clearCookies() {
        Selenide.clearBrowserCookies();
    }
}
