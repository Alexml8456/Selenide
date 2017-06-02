package backoffice.login;

import backoffice.configs.BaseTest;
import org.junit.Test;

import static backoffice.Gherkin.*;
import static com.codeborne.selenide.Condition.text;

public class UnSuccessLogin extends BaseTest {

    static LoginPage loginPage = new LoginPage();

    @Test
    public void wrongPermissions() {
        WHEN("User login with wrong permissions");
        loginPage.login("test_fc", "test");

        EXPECT("Warning PopUp should be displayed");
        loginPage.getDangerAlert().shouldHave(text("Authentication Failed: User does not have required permissions"));
    }

    @Test
    public void disabledUser() {
        WHEN("Disabled user login");
        loginPage.login("mk892545", "qwerty");

        EXPECT("Warning PopUp should be displayed");
        loginPage.getDangerAlert().shouldHave(text("User is expired or disabled"));
    }

    @Test
    public void wrongCredentials() {
        WHEN("User login with wrong credentials");
        loginPage.login("test_user", "test_user");

        EXPECT("Warning PopUp should be displayed");
        loginPage.getDangerAlert().shouldHave(text("Invalid credentials"));
    }
}