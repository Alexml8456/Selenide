package backoffice;

import backoffice.about.AboutScenarios;
import backoffice.login.SuccessLogin;
import backoffice.login.UnSuccessLogin;
import backoffice.rollover.schedulers.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        SuccessLogin.class,
        UnSuccessLogin.class,
        AboutScenarios.class,
        RolloverSchedulerScenarios.class,
        EditSchedulerScenarios.class,
        CloneSchedulerScenarios.class,
        SchedulerValidationScenarios.class,
        SimulateValidationScenarios.class,
        SimulateSchedulerScenarios.class
})

public class TestSuites {
}
