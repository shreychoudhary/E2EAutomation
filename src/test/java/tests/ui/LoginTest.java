package tests.ui;

import org.testng.annotations.Test;

import base.BaseTest;
import core.DriverFactory;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        new LoginPage(DriverFactory.get())
            .login("tomsmith", "SuperSecretPassword!");
    }
}
