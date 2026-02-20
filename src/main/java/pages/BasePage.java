package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class BasePage {

    protected void click(By locator) {
        WaitUtils.waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = WaitUtils.waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected List<WebElement> listOfElements(By locator) {
        return WaitUtils.waitForAllVisible(locator);
    }

    protected List<String> getTexts(By locator) {
        return listOfElements(locator)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    protected String getText(By locator) {
        return WaitUtils.waitForVisible(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return WaitUtils.waitForVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
