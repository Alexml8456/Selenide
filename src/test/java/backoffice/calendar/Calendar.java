package backoffice.calendar;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    public SelenideElement calendarButton = $("button.btn.btn-outline");

    public static class CalendarDialog extends Calendar {
        public SelenideElement todayButton = $(byText("Today"));
    }
}