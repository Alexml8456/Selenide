package backoffice.rollover.configuration;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class ConfigurationPage {
    public SelenideElement simulateNow = $("div[ng-hide=\"ctrl.controlsState.sim\"]");
    public SelenideElement delete = $("div[ng-hide=\"ctrl.controlsState.del\"]");
    public SelenideElement newScheduler = $("span[ng-click=\"userCtrl.rollovers.hasManagePermissions && ctrl.new()\"]");
    public SelenideElement hideOldSchedulers = $("label[for=\"old\"]");
    public SelenideElement selectAll = $("label[for=\"selectedAll\"]");
    public SelenideElement statusFilter = $("span[popover-title=\"Status filter\"]");
    public SelenideElement statusFilterFiled = $(by("ng-model","ctrl.statusFilter"));
}
