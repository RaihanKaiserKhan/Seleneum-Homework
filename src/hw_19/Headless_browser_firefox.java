package hw_19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Headless_browser_firefox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://www.amazon.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(2000);
		System.out.println("Current URL is: " + driver.getCurrentUrl());
		driver.quit();
	}
}