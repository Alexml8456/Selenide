package backoffice.login;

import backoffice.menu.TopMenuPage;
import backoffice.configs.BaseTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static backoffice.Gherkin.*;
import static com.codeborne.selenide.Condition.visible;

public class SuccessLogin extends BaseTest {

    static LoginPage loginPage = new LoginPage();
    static TopMenuPage topMenuPage = new TopMenuPage();

    @AfterClass
    public static void logOut() {
        topMenuPage.clickLogoutLink();
    }

    @Test
    public void successfulLogin() {
        WHEN("User login");
        loginPage.login(getUserName(), getPassword());

        EXPECT("Logout link and welcome message should be present");
        topMenuPage.getLogoutLink().shouldBe(visible);
        topMenuPage.getWelcome().shouldHave(text("Welcome user2_fd"));
    }
}