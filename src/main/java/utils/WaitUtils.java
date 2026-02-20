package utils;

import core.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class WaitUtils {

    private static final int TIMEOUT = 15;
    private static final int POLLING = 500;

    private static WebDriverWait getWait() {
        return new WebDriverWait(
                DriverFactory.get(),
                Duration.ofSeconds(TIMEOUT)
        );
    }

    public static WebElement waitForVisible(By locator) {
        return getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }
    public static List<WebElement> waitForAllVisible(By locator) {
        return getWait().until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)
        );
    }
    public static WebElement waitForClickable(By locator) {
        return getWait().until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static boolean waitForInvisibility(By locator) {
        return getWait().until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }

    public static void waitForPageLoad() {
        new WebDriverWait(DriverFactory.get(), Duration.ofSeconds(TIMEOUT))
                .until(driver ->
                        ((JavascriptExecutor) driver)
                                .executeScript("return document.readyState")
                                .equals("complete"));
    }
}
