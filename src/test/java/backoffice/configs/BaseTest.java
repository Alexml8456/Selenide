package backoffice.configs;

import backoffice.utils.listener.CustomEventListener;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.support.events.WebDriverEventListener;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static backoffice.PropertyReader.getConfig;
import static com.codeborne.selenide.WebDriverRunner.webdriverContainer;


public class BaseTest {

    private static final String USER_NAME = "user";
    private static final String PASSWORD = "password";
    private static final String APP_URL = "app.url";
    private static final String TEST_BROWSER = "test.browser";
    private static final String BROWSER_SIZE = "browser.size";
    private static final String TEST_TIMEOUT = "test.timeout";

    private static Properties config;

    @BeforeClass
    public static void onceExecutedBeforeAll() {
        config();
        addListener(new CustomEventListener());
        openPage();
    }

    private static void config() {
        config = getConfig();

        Configuration.baseUrl = config.getProperty(APP_URL);
        Configuration.browser = config.getProperty(TEST_BROWSER);
        Configuration.browserSize = config.getProperty(BROWSER_SIZE);
        Configuration.timeout = Long.valueOf(config.getProperty(TEST_TIMEOUT));
        //Configuration.fastSetValue = true;
        //Configuration.startMaximized = true;
    }

    private static void openPage() {
        Selenide.open("/");
    }

    public static void addListener(WebDriverEventListener listener) {
        webdriverContainer.addListener(listener);
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