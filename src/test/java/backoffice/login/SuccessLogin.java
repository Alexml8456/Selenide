package backoffice.login;

import backoffice.menu.TopMenuPage;
import backoffice.configs.BaseTest;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static backoffice.Gherkin.*;
import static com.codeborne.selenide.Condition.visible;

public class SuccessLogin extends BaseTest {

    LoginPage loginPage = new LoginPage();
    TopMenuPage topMenuPage = new TopMenuPage();

    @After
    public void logOut() {
        topMenuPage.clickLogoutLink();
    }

    @Test
    public void successfulLogin() {
        GIVEN("Open main page");
        loginPage.open();

        WHEN("User successfully login");
        loginPage.login(getUserName(), getPassword());

        EXPECT("Logout link and welcome message should be present");
        topMenuPage.logoutLink.shouldBe(visible);
        topMenuPage.welcome.shouldHave(text("Welcome user2_fd"));
    }
}