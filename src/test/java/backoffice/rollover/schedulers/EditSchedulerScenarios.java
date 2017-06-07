package backoffice.rollover.schedulers;

import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.rollover.configuration.ConfigurationPage;
import backoffice.utils.datetime.DateTime;
import org.junit.*;

import static backoffice.Gherkin.EXPECT;
import static backoffice.Gherkin.WHEN;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTitle;

public class EditSchedulerScenarios extends BaseTest {

    static final LoginPage loginPage = new LoginPage();
    static final TopMenuPage topMenuPage = new TopMenuPage();
    static final ConfigurationPage configurationPage = new ConfigurationPage();

    @BeforeClass
    public static void login() {
        loginPage.login(getUserName(), getPassword());
        configurationPage.deleteNewSchedulers();
    }

    @Before
    public void createScheduler() {
        configurationPage.createNewDateScheduler("OIL", "/CLF5", "May", "15");
    }

    @Test
    public void editSchedulerByButton() {
        WHEN("User should edit rollover scheduler by button");
        configurationPage.getEditButton().first().click();
        configurationPage.getRolloverDialog().getSymbolField().setValue("COCOA");
        configurationPage.getRolloverDialog().getSymbolDropDownMenu().$(byTitle("COCOA")).click();
        configurationPage.getRolloverDialog().getNextPeriod().setValue("/CCZ7");
        configurationPage.getRolloverDialog().getNextPeriodDropDownMenu().$(byTitle("/CCZ7")).click();
        configurationPage.getRolloverDialog().getMidDiff().setValue("0.951");
        configurationPage.getRolloverDialog().getSaveButton().click();

        EXPECT("Rollover scheduler should be edit");
        configurationPage.getSymbols().first().shouldHave(text("COCOA"));
        configurationPage.getDates().first().shouldHave(attribute("value", "15/05/" + (DateTime.getCurrentYear() + 1)));
        configurationPage.getNextMddPeriod().first().shouldHave(attribute("value", "/CCZ7"));
        configurationPage.getMidDiffToUse().first().shouldHave(attribute("value", "0.951"));
    }

    @Test
    public void editSchedulerInRuntime() {
        WHEN("User should edit rollover scheduler in runtime");
        configurationPage.calendar.openCalendarDialog();
        configurationPage.calendar.selectToday();
        configurationPage.getNextMddPeriod().first().setValue("/CLZ7").setValue("/CLZ7");
        configurationPage.getMidDiffToUse().first().setValue("-0.13").setValue("-0.13");

        EXPECT("Rollover scheduler should be edit");
        configurationPage.getDates().first().shouldHave(attribute("value", DateTime.getCurrentDate()));
        configurationPage.getSymbols().first().shouldHave(text("OIL"));
        configurationPage.getNextMddPeriod().first().shouldHave(attribute("value", "/CLZ7"));
        configurationPage.getMidDiffToUse().first().shouldHave(attribute("value", "-0.13"));
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