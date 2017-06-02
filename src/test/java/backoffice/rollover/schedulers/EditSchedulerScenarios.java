package backoffice.rollover.schedulers;

import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.rollover.configuration.ConfigurationPage;
import backoffice.utils.datetime.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static backoffice.Gherkin.EXPECT;
import static backoffice.Gherkin.WHEN;
import static com.codeborne.selenide.Selectors.byTitle;

public class EditSchedulerScenarios extends BaseTest {

    static final LoginPage loginPage = new LoginPage();
    static final TopMenuPage topMenuPage = new TopMenuPage();
    static final ConfigurationPage configurationPage = new ConfigurationPage();

    @BeforeClass
    public static void login() {
        loginPage.login(getUserName(), getPassword());
        configurationPage.deleteNewSchedulers();
        configurationPage.createNewScheduler("OIL", "/CLF5");
    }

    @Test
    public void editSchedulerByButton() {
        WHEN("User should edit rollover scheduler by button");
        configurationPage.getEditButton().first().click();
        configurationPage.getRolloverDialog().getSymbolField().setValue("COCOA");
        configurationPage.getRolloverDialog().getSymbolDropDownMenu().$(byTitle("COCOA")).click();
        configurationPage.getRolloverDialog().getNextPeriod().setValue("/CCH4");
        configurationPage.getRolloverDialog().getNextPeriodDropDownMenu().$(byTitle("/CCH4")).click();
        configurationPage.getRolloverDialog().getMidDiff().setValue("0.951");
        configurationPage.getRolloverDialog().getSaveButton().click();

        EXPECT("Rollover scheduler should be edit");
    }

    @After
    public void deleteNewSchedulers() {
        configurationPage.deleteNewSchedulers();
    }

    @AfterClass
    public static void logOut() {
        topMenuPage.clickLogoutLink();
    }

}
