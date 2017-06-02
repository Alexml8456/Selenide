package backoffice.about;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;
import static com.codeborne.selenide.Selenide.$;

public class AboutDialog {
    private SelenideElement aboutPopUp = $("div[ng-controller=\"AboutCtrl as about\"]");
    private SelenideElement aboutHeader = this.aboutPopUp.$("div.modal-header");
    private SelenideElement closeButton = this.aboutPopUp.$("button[ng-click=\"modal.close()\"]");
    private ElementsCollection aboutContext = this.aboutPopUp.$$("div[ng-repeat=\"(key, value) in about.info\"]");

    @Step
    public void clickCloseButton() {
        this.closeButton.click();
    }


    public SelenideElement getAboutHeader() {
        return aboutHeader;
    }

    public ElementsCollection getAboutContext() {
        return aboutContext;
    }
}