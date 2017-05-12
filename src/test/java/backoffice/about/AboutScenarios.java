package backoffice.about;


import backoffice.configs.BaseTest;
import backoffice.login.LoginPage;
import backoffice.menu.TopMenuPage;
import backoffice.sidebar.SideBarNavigation;
import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;

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
        sleep(3000);
        boolean test = angularHasFinishedProcessing();
        System.out.println(test);
        sideBar.aboutButton.shouldBe(Condition.exist).click();
        System.out.println(aboutPage.aboutHeader.getText());
        //System.out.println(aboutPage.aboutPopUp.getText());
        aboutPage.clickCloseButton();
    }

    private boolean angularHasFinishedProcessing(){
        String angularReadyScript = "return (window.angular !== undefined) && (angular.element(document.body).injector() !== undefined) && (angular.element(document.body).injector().get('$http').pendingRequests.length === 0)";
        //return Boolean.valueOf(executeJavaScript("return (window.angular !== undefined)").toString());
        //return Boolean.valueOf(executeJavaScript("return angular.element(document).injector() === undefined").toString());
        return Boolean.valueOf(executeJavaScript(angularReadyScript).toString());
    }
}