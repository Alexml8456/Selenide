package backoffice.login;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement userName = $(by("ng-model", "authCtrl.credentials.username"));
    private SelenideElement password = $(by("ng-model", "authCtrl.credentials.password"));
    private SelenideElement signInButton = $("[ng-disabled=\"loginForm.$invalid\"]");


    public void open() {
        Selenide.open("/");
    }

    public void inputUserName(String user) {
        this.userName.setValue(user);
    }

    public void inputPassword(String password) {
        this.password.setValue(password);
    }

    public void clickSingInButton() {
        this.signInButton.click();
    }

    public void login (String user, String password){
        this.open();
        this.inputUserName(user);
        this.inputPassword(password);
        this.clickSingInButton();
    }
}
