package backoffice.rollover.schedulers;

import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.rollover.configuration.ConfigurationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RolloverSchedulerScenarios extends BaseTest {

    static LoginPage loginPage = new LoginPage();
    static TopMenuPage topMenuPage = new TopMenuPage();
    static ConfigurationPage configurationPage = new ConfigurationPage();

    @Before
    public void login() {
        loginPage.login(getUserName(), getPassword());
        configurationPage.deleteNewSchedulers();
    }

    @After
    public void logOut() {
        topMenuPage.clickLogoutLink();
    }

    @Test
    public void createNewScheduler() {
        configurationPage.createNewScheduler("OIL", "/CLZ7");
    }
}