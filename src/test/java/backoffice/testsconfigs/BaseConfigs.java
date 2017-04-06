package backoffice.testsconfigs;

import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import java.util.Properties;

import static backoffice.PropertyReader.getConfig;


public class BaseConfigs {

    public static final String USER_NAME = "user";
    public static final String PASSWORD = "password";
    public static final String APP_URL = "app.url";
    public static final String TEST_BROWSER = "test.browser";
    public static final String BROWSER_SIZE = "browser.size";
    public static final String TEST_TIMEOUT = "test.timeout";

    private static Properties config;

    @BeforeClass
    public static void config() {
        config = getConfig();

        Configuration.baseUrl = config.getProperty(APP_URL);
        Configuration.browser = config.getProperty(TEST_BROWSER);
        Configuration.browserSize = config.getProperty(BROWSER_SIZE);
        Configuration.timeout = Long.valueOf(config.getProperty(TEST_TIMEOUT));

    }

    public static String getUserName() {
        return config.getProperty(USER_NAME);
    }

    public static String getPassword() {
        return config.getProperty(PASSWORD);
    }
}
