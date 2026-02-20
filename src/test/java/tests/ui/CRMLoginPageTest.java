package tests.ui;

import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import pages.CRMLoginPage;

public class CRMLoginPageTest extends BaseTest {
	CRMLoginPage crmLoginPage = new CRMLoginPage();

	@Test(priority = 1)
	public void validLogin() {
		crmLoginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
	}

	@Test(priority = 2)
	public void getTextforAtag() {
		//crmLoginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
		crmLoginPage.getAllLinksText();
	}
}
