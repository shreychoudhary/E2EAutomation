package pages;

import org.openqa.selenium.By;

public class CRMLoginPage extends BasePage{

	private By username = By.xpath("//*[@name='email']");
	private By password = By.name("password");
    private By loginBtn = By.xpath("//*[text()='Login']");
    private By homepageLinks = By.xpath("//*[@class='menu-item-wrapper']//a//span");
    
	 public void login(String user, String pass) {
	        type(username, user);
	        type(password, pass);
	        click(loginBtn);
	    }
	 public void getAllLinksText() {
		 System.out.println(getTexts(homepageLinks));		 
	 }

}
