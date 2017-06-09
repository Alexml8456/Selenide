package backoffice.rollover.schedulers;

import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.rollover.configuration.ConfigurationPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static backoffice.Gherkin.EXPECT;
import static backoffice.Gherkin.WHEN;
import static com.codeborne.selenide.Condition.text;

public class SchedulerValidationScenarios extends BaseTest{

    static final LoginPage loginPage = new LoginPage();
    static final TopMenuPage topMenuPage = new TopMenuPage();
    static final ConfigurationPage configurationPage = new ConfigurationPage();

    @BeforeClass
    public static void login() {
        loginPage.login(getUserName(), getPassword());
        configurationPage.deleteNewSchedulers();
        configurationPage.createNewManualScheduler("OIL", "/CLF5", 2);
    }

    @Test
    public void createSchedulerWithIdenticalDatePeriod() {
        WHEN("User try to create new scheduler with identical date and next period");
        configurationPage.createNewScheduler("OIL", "/CLF5");
        EXPECT("Validation message should be displayed");
        configurationPage.getAlertMessage().shouldHave(text("Failed to save scheduler due to validation errors. Please check highlighted fields."));

    }

    @Test
    public void createSchedulerWithIdenticalDate() {
        WHEN("User try to create new scheduler with identical date");
        configurationPage.createNewScheduler("OIL", "/CLF6");
        EXPECT("Validation message should be displayed");
        configurationPage.getAlertMessage().shouldHave(text("Failed to save scheduler due to validation errors. Please check highlighted fields."));

    }

    @Test
    public void createSchedulerWithIdenticalPeriod() {
        WHEN("User try to create new scheduler with identical next period");
        configurationPage.createNewDateScheduler("OIL", "/CLF5", "May", "20");
        EXPECT("Validation message should be displayed");
        configurationPage.getAlertMessage().shouldHave(text("Failed to save scheduler due to validation errors. Please check highlighted fields."));

    }

    @After
    public void clickCancelButton() {
        configurationPage.getRolloverDialog().getCancelButton().click();
    }

    @AfterClass
    public static void logOut() {
        topMenuPage.clickLogoutLink();
    }
}
