package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void init() {
		WebDriverManager.chromedriver().setup();
		System.out.println("Driver Initialized: " + Thread.currentThread().getId());

		ChromeOptions options = new ChromeOptions();

		// ✅ REQUIRED FOR JENKINS / CI options.addArguments("--headless=new");
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--window-size=1920,1080");

		driver.set(new ChromeDriver(options));
		get().manage().window().maximize();
	}

	public static WebDriver get() {
		return driver.get();
	}

	public static void quit() {
		get().quit();
		driver.remove();
	}
}
