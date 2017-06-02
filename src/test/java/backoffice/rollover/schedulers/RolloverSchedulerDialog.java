package backoffice.rollover.schedulers;

import backoffice.calendar.Calendar;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class RolloverSchedulerDialog {
    private SelenideElement rolloverSchedulerDialog = $("div[ng-controller=\"EditRolloverCtrl as editRolloverCtrl\"]");
    private SelenideElement saveButton = this.rolloverSchedulerDialog.$("button[ng-click=\"editRolloverCtrl.save()\"]");
    private SelenideElement cancelButton = this.rolloverSchedulerDialog.$("button[ng-click=\"editRolloverCtrl.cancel()\"]");
    private SelenideElement symbolField = this.rolloverSchedulerDialog.$(by("ng-model", "editRolloverCtrl.item.symbol"));
    private SelenideElement symbolDropDownMenu = this.rolloverSchedulerDialog.$$(".dropdown-menu").get(0);
    private SelenideElement nextPeriod = this.rolloverSchedulerDialog.$(by("ng-model", "editRolloverCtrl.item.nextPeriod"));
    private SelenideElement nextPeriodDropDownMenu = this.rolloverSchedulerDialog.$$(".dropdown-menu").get(1);
    private SelenideElement midDiff = this.rolloverSchedulerDialog.$(by("ng-model", "editRolloverCtrl.item.manMidPrice"));
    private SelenideElement disabledEnabled = this.rolloverSchedulerDialog.$("label[for='enable']");
    public Calendar calendar;

    public RolloverSchedulerDialog() {
        calendar = new Calendar();
    }

    public SelenideElement getSaveButton() {
        return saveButton;
    }

    public SelenideElement getCancelButton() {
        return cancelButton;
    }

    public SelenideElement getSymbolField() {
        return symbolField;
    }

    public SelenideElement getSymbolDropDownMenu() {
        return symbolDropDownMenu;
    }

    public SelenideElement getNextPeriod() {
        return nextPeriod;
    }

    public SelenideElement getNextPeriodDropDownMenu() {
        return nextPeriodDropDownMenu;
    }

    public SelenideElement getMidDiff() {
        return midDiff;
    }

    public SelenideElement getDisabledEnabled() {
        return disabledEnabled;
    }
}