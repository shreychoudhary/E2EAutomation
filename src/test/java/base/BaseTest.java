package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.ConfigReader;
import core.DriverFactory;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverFactory.init();
        DriverFactory.get()
            .get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.quit();
    }
}

