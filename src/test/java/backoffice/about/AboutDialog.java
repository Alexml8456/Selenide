package backoffice.about;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class AboutDialog {
    public SelenideElement aboutHeader = $("div.modal-header");
    private SelenideElement closeButton = $("button[ng-click=\"modal.close()\"]");
    private SelenideElement aboutContextKeys = $(byAttribute("binding", "key"));
    private SelenideElement aboutContextValues = $(byAttribute("binding", "value"));
    //public SelenideElement aboutPopUp = $("div[ng-controller=\"AboutCtrl as about\"]");

    @Step
    public void clickCloseButton() {
        this.closeButton.click();
    }
}