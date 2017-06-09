package backoffice.rollover.schedulers;

import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.rollover.configuration.ConfigurationPage;
import backoffice.utils.datetime.DateTime;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static backoffice.Gherkin.EXPECT;
import static backoffice.Gherkin.WHEN;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTitle;

public class CloneSchedulerScenarios extends BaseTest {
    static final LoginPage loginPage = new LoginPage();
    static final TopMenuPage topMenuPage = new TopMenuPage();
    static final ConfigurationPage configurationPage = new ConfigurationPage();

    @BeforeClass
    public static void login() {
        loginPage.login(getUserName(), getPassword());
        configurationPage.deleteNewSchedulers();
        configurationPage.createNewDateScheduler("OIL", "/CLF5", "May", "15");
    }

    @Test
    public void cloneScheduler() {
        WHEN("User should clone scheduler");
        configurationPage.getCloneButton().first().click();
        configurationPage.getRolloverDialog().getSymbolField().setValue("GOLD");
        configurationPage.getRolloverDialog().getSymbolDropDownMenu().$(byTitle("GOLD")).click();
        configurationPage.getRolloverDialog().getNextPeriod().setValue("/GCZ7");
        configurationPage.getRolloverDialog().getNextPeriodDropDownMenu().$(byTitle("/GCZ7")).click();
        configurationPage.getRolloverDialog().getMidDiff().setValue("6.95");
        configurationPage.calendar.openCalendarDialog();
        configurationPage.calendar.selectToday();
        configurationPage.getRolloverDialog().getSaveButton().click();

        EXPECT("Rollover scheduler should be cloned");
        configurationPage.getSymbols().first().shouldHave(text("GOLD"));
        configurationPage.getDates().first().shouldHave(attribute("value", DateTime.getCurrentDate()));
        configurationPage.getNextMddPeriod().first().shouldHave(attribute("value", "/GCZ7"));
        configurationPage.getMidDiffToUse().first().shouldHave(attribute("value", "6.95"));
        configurationPage.getSymbols().shouldHaveSize(2);
    }

    @AfterClass
    public static void logOut() {
        topMenuPage.clickLogoutLink();
    }
}
