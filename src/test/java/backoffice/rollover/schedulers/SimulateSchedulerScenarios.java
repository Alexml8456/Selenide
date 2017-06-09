package backoffice.rollover.schedulers;

import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.rollover.configuration.ConfigurationPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static backoffice.Gherkin.EXPECT;
import static backoffice.Gherkin.WHEN;
import static com.codeborne.selenide.Condition.text;

public class SimulateSchedulerScenarios extends BaseTest {

    static final LoginPage loginPage = new LoginPage();
    static final TopMenuPage topMenuPage = new TopMenuPage();
    static final ConfigurationPage configurationPage = new ConfigurationPage();

    @BeforeClass
    public static void login() {
        loginPage.login(getUserName(), getPassword());
        configurationPage.deleteNewSchedulers();
        configurationPage.createNewManualScheduler("CORN", "/ZCZ7", 3.951);
    }

    @Test
    public void validationSimulateScheduler() {
        WHEN("User simulate scheduler");
        configurationPage.getSelectAll().click();
        configurationPage.getSimulateNow().click();
        EXPECT("Validation message should be displayed");
        configurationPage.getAlertMessage().shouldHave(text("Simulation of 'CORN' has been finished."));

    }

    @AfterClass
    public static void logOut() {
        topMenuPage.clickLogoutLink();
    }
}