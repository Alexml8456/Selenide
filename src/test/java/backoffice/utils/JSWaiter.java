package backoffice.utils;


import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JSWaiter {

    public static void waitForAngularLoad() {
        String angularReadyScript = "return (window.angular !== undefined) && (angular.element(document.body).injector() !== undefined) && (angular.element(document.body).injector().get('$http').pendingRequests.length === 0)";
        boolean angularReady = Boolean.valueOf(executeJavaScript(angularReadyScript).toString());

    }
}
