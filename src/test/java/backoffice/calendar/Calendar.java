package backoffice.calendar;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Calendar {
    private SelenideElement calendarButton = $("button.btn.btn-outline");
    private SelenideElement todayButton = $(byText("Today"));
    private SelenideElement dateButton = $("th[colspan='6']");
    private SelenideElement moveNextButton = $("button[ng-click='move(1)']");

    public void openCalendarDialog(){
        this.calendarButton.should(appear).hover().click();
    }

    public void selectToday(){
        this.todayButton.click();
    }

    private void clickToElementByText(String inputText){
        $$(byText(inputText)).first().click();
    }

    public void selectDate(String selectMonth, String selectDay){
        this.calendarButton.click();
        this.dateButton.click();
        this.moveNextButton.click();
        this.clickToElementByText(selectMonth);
        this.clickToElementByText(selectDay);

    }
}