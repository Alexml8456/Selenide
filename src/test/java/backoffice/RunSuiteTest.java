package backoffice;

import backoffice.about.AboutScenarios;
import backoffice.login.SuccessLogin;
import backoffice.login.UnSuccessLogin;
import backoffice.rollover.schedulers.RolloverSchedulerScenarios;
import backoffice.rollover.schedulers.EditSchedulerScenarios;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
/*        SuccessLogin.class,
        UnSuccessLogin.class,
        AboutScenarios.class,
        RolloverSchedulerScenarios.class,*/
        EditSchedulerScenarios.class
})

public class RunSuiteTest {
}
