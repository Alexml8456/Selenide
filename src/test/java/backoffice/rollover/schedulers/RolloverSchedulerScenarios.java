package backoffice.rollover.schedulers;


import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.rollover.configuration.ConfigurationPage;
import backoffice.utils.SelectWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RolloverSchedulerScenarios extends BaseTest {

    static LoginPage loginPage = new LoginPage();
    static TopMenuPage topMenuPage = new TopMenuPage();
    static ConfigurationPage configurationPage = new ConfigurationPage();
    static RolloverSchedulerDialog rolloverSchedulerDialog = new RolloverSchedulerDialog();
    static SelectWrapper selectWrapper = new SelectWrapper();

    @Before
    public void login() {
        loginPage.login(getUserName(), getPassword());
    }

    @After
    public void logOut() {
        topMenuPage.clickLogoutLink();
    }

    @Test
    public void createNewScheduler() {
        configurationPage.newScheduler.click();
        rolloverSchedulerDialog.symbolField.sendKeys("OIL");
        selectWrapper.selectByTitle(rolloverSchedulerDialog.symbolDropDownMenu, "OIL");
        rolloverSchedulerDialog.cancelButton.click();
    }
}