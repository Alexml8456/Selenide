package backoffice.utils;

import com.codeborne.selenide.SelenideElement;

public class SelectWrapper {
    public void selectByTitle(SelenideElement selector, String title) {
        selector.$("a[title=\"" + title + "\"]").click();
    }
}