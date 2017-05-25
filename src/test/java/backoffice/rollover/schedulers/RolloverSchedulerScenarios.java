package backoffice.rollover.schedulers;

import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.rollover.configuration.ConfigurationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byTitle;

public class RolloverSchedulerScenarios extends BaseTest {

    static LoginPage loginPage = new LoginPage();
    static TopMenuPage topMenuPage = new TopMenuPage();
    static ConfigurationPage configurationPage = new ConfigurationPage();
    static RolloverSchedulerDialog rolloverSchedulerDialog = new RolloverSchedulerDialog();

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
        configurationPage.newScheduler.click();
        rolloverSchedulerDialog.symbolField.setValue("OIL");
        rolloverSchedulerDialog.symbolDropDownMenu.$(byTitle("OIL")).click();
        rolloverSchedulerDialog.nextPeriod.setValue("/CLZ7");
        rolloverSchedulerDialog.nextPeriodDropDownMenu.$(byTitle("/CLZ7")).click();
        //rolloverSchedulerDialog.cancelButton.click();
        rolloverSchedulerDialog.saveButton.click();
    }
}