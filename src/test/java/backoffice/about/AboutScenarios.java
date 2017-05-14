package backoffice.about;


import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.sidebar.SideBarNavigation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void logOut() {
        topMenuPage.clickLogoutLink();
    }

    @Test
    public void commonInformation() {
        sideBar.clickAboutButton();
        aboutDialog.aboutHeader.shouldHave(text("About Sputnik-1"));
        aboutDialog.aboutContext.shouldHave(size(14));
        aboutDialog.clickCloseButton();
    }
}