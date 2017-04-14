package backoffice.configs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.BeforeClass;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static backoffice.PropertyReader.getConfig;


public class BaseTest {

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
        //Configuration.browserSize = config.getProperty(BROWSER_SIZE);
        Configuration.timeout = Long.valueOf(config.getProperty(TEST_TIMEOUT));

    }

    public static String getUserName() {
        return config.getProperty(USER_NAME);
    }

    public static String getPassword() {
        return config.getProperty(PASSWORD);
    }


    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File testResultScreenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(testResultScreenshot);
    }
}
