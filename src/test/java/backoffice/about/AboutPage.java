package backoffice.about;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class AboutPage {
    public SelenideElement aboutHeader = $("div.modal-header");
    private SelenideElement closeButton = $("button[ng-click=\"modal.close()\"]");
    private SelenideElement aboutContextKeys = $(byAttribute("binding", "key"));
    private SelenideElement aboutContextValues = $(byAttribute("binding", "value"));

    @Step
    public void clickCloseButton() {
        this.closeButton.click();
    }
}