package backoffice.menu;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class TopMenuPage {
    public SelenideElement logoutLink = $("[ng-click=\"mainCtrl.logout()\"]");
    public SelenideElement welcome = $(by("ng-binding", "mainCtrl.user.name"));


    public void clickLogoutLink() {
        this.logoutLink.click();
    }
}
