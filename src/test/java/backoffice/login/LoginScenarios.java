package backoffice.login;

import backoffice.menu.TopMenuPage;
import backoffice.testsconfigs.BaseConfigs;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exist;

public class LoginScenarios extends BaseConfigs {

    LoginPage loginPage = new LoginPage();
    TopMenuPage topMenuPage = new TopMenuPage();

    @After
    public void logOut() {
        topMenuPage.clickLogoutLink();
    }


    @Test
    public void openPage() {
        loginPage.login("user2_fd","test");
        topMenuPage.logoutLink.shouldBe(exist);
    }
}
