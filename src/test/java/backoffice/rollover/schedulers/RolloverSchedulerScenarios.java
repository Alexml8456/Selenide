package backoffice.rollover.schedulers;

import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.rollover.configuration.ConfigurationPage;
import backoffice.utils.datetime.DateTime;
import org.junit.*;

import static backoffice.Gherkin.EXPECT;
import static backoffice.Gherkin.WHEN;
import static com.codeborne.selenide.Condition.*;

public class RolloverSchedulerScenarios extends BaseTest {

    static final LoginPage loginPage = new LoginPage();
    static final TopMenuPage topMenuPage = new TopMenuPage();
    static final ConfigurationPage configurationPage = new ConfigurationPage();

    @BeforeClass
    public static void login() {
        loginPage.login(getUserName(), getPassword());
        configurationPage.deleteNewSchedulers();
    }

    @Test
    public void createNewScheduler() {
        WHEN("User create new rollover scheduler");
        configurationPage.createNewScheduler("OIL", "/CLZ7");

        EXPECT("Rollover scheduler should be created");
        configurationPage.getSymbols().first().shouldHave(text("OIL"));
        configurationPage.getDates().first().shouldHave(attribute("value", DateTime.getCurrentDate()));
        configurationPage.getNextMddPeriod().first().shouldHave(attribute("value", "/CLZ7"));
        configurationPage.getCurMidDiff().first().shouldNotHave(text("N/A"));
    }

    @Test
    public void createManualAutoRunScheduler() {
        WHEN("User create new rollover scheduler with manual MidDiff");
        configurationPage.createManualAutoRunScheduler("COCOA", "/CCZ7", 2.236);

        EXPECT("Rollover scheduler with manual MidDiff should be created");
        configurationPage.getSymbols().first().shouldHave(text("COCOA"));
        configurationPage.getDates().first().shouldHave(attribute("value", DateTime.getCurrentDate()));
        configurationPage.getNextMddPeriod().first().shouldHave(attribute("value", "/CCZ7"));
        configurationPage.getCurMidDiff().first().shouldNotHave(text("N/A"));
        configurationPage.getMidDiffToUse().first().shouldHave(attribute("value", "2.236"));
        configurationPage.getDisabledEnabled().first().shouldBe(enabled);
    }

    @Test
    public void createCustomPeriodNewScheduler() {
        WHEN("User create new rollover scheduler with custom period");
        configurationPage.createCustomPeriodNewScheduler("COCOA", "1@3QwE");

        EXPECT("Rollover scheduler with custom period should be created");
        configurationPage.getSymbols().first().shouldHave(text("COCOA"));
        configurationPage.getDates().first().shouldHave(attribute("value", DateTime.getCurrentDate()));
        configurationPage.getNextMddPeriod().first().shouldHave(attribute("value", "1@3QwE"));
        configurationPage.getCurMidDiff().first().shouldHave(text("N/A"));
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