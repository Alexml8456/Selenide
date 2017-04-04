package backoffice.testsconfigs;

import com.codeborne.selenide.Configuration;

public class BaseConfigs {

    {
        Configuration.baseUrl = "http://192.168.4.127:8901";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1200";
        Configuration.timeout = 15000;
    }
}
