package backoffice.calendar;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    private SelenideElement calendarButton = $("button.btn.btn-outline");
    private CalendarDialog calendarDialog = new CalendarDialog();

    public class CalendarDialog {
        private SelenideElement todayButton = $(byText("Today"));

        public SelenideElement getTodayButton() {
            return todayButton;
        }
    }

    public SelenideElement getCalendarButton() {
        return calendarButton;
    }

    public CalendarDialog getCalendarDialog() {
        return calendarDialog;
    }
}