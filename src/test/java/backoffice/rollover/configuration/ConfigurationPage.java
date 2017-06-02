package backoffice.rollover.configuration;


import backoffice.rollover.schedulers.RolloverSchedulerDialog;
import backoffice.utils.wait.AngularWait;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static java.lang.String.valueOf;

public class ConfigurationPage {
    private SelenideElement simulateNow = $("div[ng-hide=\"ctrl.controlsState.sim\"]");
    private SelenideElement delete = $("div[ng-show=\"ctrl.controlsState.del\"]");
    private SelenideElement newScheduler = $("span[ng-click=\"userCtrl.rollovers.hasManagePermissions && ctrl.new()\"]");
    private SelenideElement hideOldSchedulers = $("label[for=\"old\"]");
    private SelenideElement selectAll = $("label[for='selectedAll']");
    private SelenideElement statusFilter = $("span[popover-title=\"Status filter\"]");
    private SelenideElement statusFilterFiled = $(by("ng-model", "ctrl.statusFilter"));
    private ElementsCollection symbols = $$("label.checkbox-custom-label.ng-binding");
    private SelenideElement removeAllFilters = $("div[ng-click=\"ctrl.removeAllFilters()\"]");
    private ElementsCollection dates = $$(by("ng-model", "model"));
    private ElementsCollection nextMddPeriod = $$(by("ng-model", "item.nextPeriod"));
    private ElementsCollection curMidDiff = $$("span[bo-animate-on-change-value='item.midPrice']");
    private ElementsCollection midDiffToUse = $$(by("ng-model", "item.manMidPrice"));
    private RolloverSchedulerDialog rolloverDialog;

    public ConfigurationPage() {
        rolloverDialog = new RolloverSchedulerDialog();
    }

    @Step
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

    @Step
    public void createNewScheduler(String inputSymbol, String inputNextPeriod) {
        this.newScheduler.click();
        rolloverDialog.calendar.openCalendarDialog();
        rolloverDialog.calendar.selectToday();
        rolloverDialog.getSymbolField().setValue(inputSymbol);
        rolloverDialog.getSymbolDropDownMenu().$(byTitle(inputSymbol)).click();
        rolloverDialog.getNextPeriod().setValue(inputNextPeriod);
        rolloverDialog.getNextPeriodDropDownMenu().$(byTitle(inputNextPeriod)).click();
        rolloverDialog.getSaveButton().click();
    }

    @Step
    public void createCustomPeriodNewScheduler(String inputSymbol, String inputNextPeriod) {
        this.newScheduler.click();
        rolloverDialog.calendar.openCalendarDialog();
        rolloverDialog.calendar.selectToday();
        rolloverDialog.getSymbolField().setValue(inputSymbol);
        rolloverDialog.getSymbolDropDownMenu().$(byTitle(inputSymbol)).click();
        rolloverDialog.getNextPeriod().setValue(inputNextPeriod);
        rolloverDialog.getSaveButton().click();
    }

    @Step
    public void createNewManualScheduler(String inputSymbol, String inputNextPeriod, double inputMidDiff) {
        this.newScheduler.click();
        rolloverDialog.calendar.openCalendarDialog();
        rolloverDialog.calendar.selectToday();
        rolloverDialog.getSymbolField().setValue(inputSymbol);
        rolloverDialog.getSymbolDropDownMenu().$(byTitle(inputSymbol)).click();
        rolloverDialog.getNextPeriod().setValue(inputNextPeriod);
        rolloverDialog.getNextPeriodDropDownMenu().$(byTitle(inputNextPeriod)).click();
        rolloverDialog.getMidDiff().setValue(valueOf(inputMidDiff));
        rolloverDialog.getSaveButton().click();
    }

    @Step
    public void createNewDateScheduler(String inputSymbol, String inputNextPeriod, String inputMonth, String inputDay) {
        this.newScheduler.click();
        rolloverDialog.calendar.selectDate(inputMonth, inputDay);
        rolloverDialog.getSymbolField().setValue(inputSymbol);
        rolloverDialog.getSymbolDropDownMenu().$(byTitle(inputSymbol)).click();
        rolloverDialog.getNextPeriod().setValue(inputNextPeriod);
        rolloverDialog.getNextPeriodDropDownMenu().$(byTitle(inputNextPeriod)).click();
        rolloverDialog.getMidDiff().setValue("9.109");
        rolloverDialog.getSaveButton().click();
    }

    public ElementsCollection getSymbols() {
        return symbols;
    }

    public ElementsCollection getDates() {
        return dates;
    }

    public ElementsCollection getNextMddPeriod() {
        return nextMddPeriod;
    }

    public ElementsCollection getCurMidDiff() {
        return curMidDiff;
    }

    public ElementsCollection getMidDiffToUse() {
        return midDiffToUse;
    }

}