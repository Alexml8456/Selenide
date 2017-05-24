package backoffice;

import backoffice.rollover.schedulers.RolloverSchedulerScenarios;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
/*        SuccessLogin.class,
        UnSuccessLogin.class,
        AboutScenarios.class,*/
        RolloverSchedulerScenarios.class
})

public class RunSuiteTest {
}
