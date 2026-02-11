package base;

import org.testng.annotations.BeforeClass;

import config.ConfigReader;
import io.restassured.RestAssured;

public class BaseAPI {

    @BeforeClass
    public void setupAPI() {
        RestAssured.baseURI =
            ConfigReader.get("apiBaseUrl");
    }
}
