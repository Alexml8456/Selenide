package backoffice.login;

import backoffice.menu.TopMenuPage;
import backoffice.configs.BaseTest;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

public class SuccessLoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    TopMenuPage topMenuPage = new TopMenuPage();

    @After
    public void logOut() {
        topMenuPage.clickLogoutLink();
    }

    @Test
    public void successfulLogin() {
        loginPage.open();
        loginPage.login(getUserName(), getPassword());
        topMenuPage.logoutLink.should(exist);
        topMenuPage.welcome.shouldHave(text("Welcome user2_fd"));
    }
}