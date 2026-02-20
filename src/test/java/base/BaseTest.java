package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import config.ConfigReader;
import core.DriverFactory;

public class BaseTest {

    @BeforeClass
    public void setup() {
        DriverFactory.init();
        DriverFactory.get()
            .get(ConfigReader.get("baseUrl"));
    }

    @AfterClass
    public void teardown() {
        DriverFactory.quit();
    }
}

