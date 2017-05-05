package backoffice;

import backoffice.about.AboutScenarios;
import backoffice.login.SuccessLogin;
import backoffice.login.UnSuccessLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        //SuccessLogin.class,
        //UnSuccessLogin.class
        AboutScenarios.class
})

public class RunSuiteTest {
}
