package backoffice.about;


import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.sidebar.SideBarNavigation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AboutScenarios extends BaseTest {

    static AboutDialog aboutPage = new AboutDialog();
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
        System.out.println(aboutPage.aboutHeader.getText());
        aboutPage.clickCloseButton();
    }
}