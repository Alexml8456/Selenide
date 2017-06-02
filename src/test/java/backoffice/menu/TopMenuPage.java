package backoffice.menu;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class TopMenuPage {
    private SelenideElement logoutLink = $("[ng-click=\"mainCtrl.logout()\"]");
    private SelenideElement welcome = $("div.col-sm-3.text-right.panel-body");

    public void clickLogoutLink() {
        this.logoutLink.click();
    }

    public SelenideElement getLogoutLink() {
        return logoutLink;
    }

    public SelenideElement getWelcome() {
        return welcome;
    }
}