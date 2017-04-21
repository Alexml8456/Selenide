package backoffice;

import backoffice.login.SuccessLogin;
import backoffice.login.UnSuccessLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        SuccessLogin.class,
        UnSuccessLogin.class
})

public class RunSuiteTest {
}
