package backoffice.rollover.schedulers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class RolloverSchedulerDialog {
    public SelenideElement rolloverSchedulerDialog = $("div[ng-controller=\"EditRolloverCtrl as editRolloverCtrl\"]");
    public SelenideElement cancelButton = this.rolloverSchedulerDialog.$("button[ng-click=\"editRolloverCtrl.cancel()\"]");
    public SelenideElement symbolField = this.rolloverSchedulerDialog.$(by("ng-model", "editRolloverCtrl.item.symbol"));
    public SelenideElement symbolDropDownMenu = this.rolloverSchedulerDialog.$$(".dropdown-menu").get(0);
    public SelenideElement nextPeriod = this.rolloverSchedulerDialog.$(by("ng-model","editRolloverCtrl.item.nextPeriod"));
    public SelenideElement nextPeriodDropDownMenu = this.rolloverSchedulerDialog.$$(".dropdown-menu").get(1);
}