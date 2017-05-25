package backoffice.rollover.configuration;


import backoffice.rollover.schedulers.RolloverSchedulerDialog;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ConfigurationPage {
    public SelenideElement simulateNow = $("div[ng-hide=\"ctrl.controlsState.sim\"]");
    public SelenideElement delete = $("div[ng-show=\"ctrl.controlsState.del\"]");
    public SelenideElement newScheduler = $("span[ng-click=\"userCtrl.rollovers.hasManagePermissions && ctrl.new()\"]");
    public SelenideElement hideOldSchedulers = $("label[for=\"old\"]");
    public SelenideElement selectAll = $("label[for=\"selectedAll\"]");
    public SelenideElement statusFilter = $("span[popover-title=\"Status filter\"]");
    public SelenideElement statusFilterFiled = $(by("ng-model", "ctrl.statusFilter"));
    public ElementsCollection symbols = $$("label.checkbox-custom-label.ng-binding");
    public SelenideElement removeAllFilters = $("div[ng-click=\"ctrl.removeAllFilters()\"]");
    private RolloverSchedulerDialog rolloverDialog = new RolloverSchedulerDialog();

    public void deleteNewSchedulers() {
        this.hideOldSchedulers.click();
        this.statusFilter.click();
        this.statusFilterFiled.setValue("New");
        this.statusFilter.click();
        if (this.symbols.size() > 0) {
            this.selectAll.click();
            this.delete.click();
            this.removeAllFilters.click();
            this.hideOldSchedulers.click();
        } else {
            this.removeAllFilters.click();
            this.hideOldSchedulers.click();
        }
    }

    public void createNewScheduler(String inputSymbol, String inputNextPeriod) {
        this.newScheduler.click();
        rolloverDialog.symbolField.setValue(inputSymbol);
        rolloverDialog.symbolDropDownMenu.$(byTitle(inputSymbol)).click();
        rolloverDialog.nextPeriod.setValue(inputNextPeriod);
        rolloverDialog.nextPeriodDropDownMenu.$(byTitle(inputNextPeriod)).click();
        rolloverDialog.saveButton.click();
    }
}