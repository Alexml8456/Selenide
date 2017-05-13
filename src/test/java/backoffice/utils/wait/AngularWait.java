package backoffice.utils.wait;

import org.openqa.selenium.support.ui.ExpectedCondition;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AngularWait {
    public static void waitForRequestsToFinish() {
        final String angularReadyScript = "return (window.angular !== undefined) && (angular.element(document.body).injector() !== undefined) && (angular.element(document.body).injector().get('$http').pendingRequests.length === 0)";
        ExpectedCondition<Boolean> angularLoad = webDriver -> Boolean.valueOf(executeJavaScript(angularReadyScript).toString());
        Wait().until(angularLoad);
    }
}