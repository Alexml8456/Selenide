package backoffice.about;


import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.sidebar.SideBarNavigation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static backoffice.Gherkin.EXPECT;
import static backoffice.Gherkin.WHEN;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;

public class AboutScenarios extends BaseTest {

    static AboutDialog aboutDialog = new AboutDialog();
    static LoginPage loginPage = new LoginPage();
    static TopMenuPage topMenuPage = new TopMenuPage();
    static SideBarNavigation sideBar = new SideBarNavigation();

    @Before
    public void login() {
        loginPage.login(getUserName(), getPassword());
    }

    @After
    public void closeAndLogOut() {
        aboutDialog.clickCloseButton();
        topMenuPage.clickLogoutLink();
    }

    @Test
    public void commonInformation() {
        WHEN("User click About button");
        sideBar.clickAboutButton();

        EXPECT("About header should be present");
        aboutDialog.aboutHeader.shouldHave(text("About Sputnik-1"));
        EXPECT("About context should contain 14 rows");
        aboutDialog.aboutContext.shouldHave(size(14));
    }
}