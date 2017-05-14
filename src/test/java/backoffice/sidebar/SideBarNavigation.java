package backoffice.sidebar;


import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class SideBarNavigation {
    private SelenideElement sidebar = $("md-sidenav[md-component-id=\"sidebar\"]");
    private SelenideElement aboutButton = this.sidebar.$("a[ng-controller=\"AboutCtrl as ctrl\"]");

    @Step
    public void clickAboutButton() {
        this.aboutButton.click();
    }
}