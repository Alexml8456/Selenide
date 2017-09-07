package backoffice.login;

import backoffice.configs.BaseTest;
import backoffice.menu.TopMenuPage;
import org.junit.AfterClass;
import org.junit.Test;

import static backoffice.Gherkin.EXPECT;
import static backoffice.Gherkin.WHEN;
import static com.codeborne.selenide.Condition.text;
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
        topMenuPage.getWelcome().shouldHave(text("Welcome alexml"));
    }
}