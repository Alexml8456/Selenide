package backoffice.login;

import backoffice.configs.BaseTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;

public class UnSuccessLogin extends BaseTest {

    static LoginPage loginPage = new LoginPage();

    @BeforeClass
    public static void openPage() {
        loginPage.open();
    }

    @Test
    public void wrongPermissions() {
        loginPage.login("test_fc", "test");
        loginPage.dangerAlert.shouldHave(text("Authentication Failed: User does not have required permissions"));
    }

    @Test
    public void disabledUser() {
        loginPage.login("mk892545", "qwerty");
        loginPage.dangerAlert.shouldHave(text("User is expired or disabled"));
    }

    @Test
    public void wrongCredentials() {
        loginPage.login("test_user", "test_user");
        loginPage.dangerAlert.shouldHave(text("Invalid credentials"));
    }
}