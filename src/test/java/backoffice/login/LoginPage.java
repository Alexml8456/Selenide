package backoffice.login;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement userName = $(by("ng-model", "authCtrl.credentials.username"));
    private SelenideElement password = $(by("ng-model", "authCtrl.credentials.password"));
    private SelenideElement signInButton = $("[ng-disabled=\"loginForm.$invalid\"]");
    public SelenideElement dangerAlert = $(".panel-title");

    @Step
    public void inputUserName(String user) {
        this.userName.setValue(user);
    }

    @Step
    public void inputPassword(String password) {
        this.password.setValue(password);
    }

    @Step
    public void clickSingInButton() {
        this.signInButton.click();
    }

    @Step
    public void login(String user, String password) {
        this.inputUserName(user);
        this.inputPassword(password);
        this.clickSingInButton();
    }
}