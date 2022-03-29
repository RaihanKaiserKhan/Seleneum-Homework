package hw_19;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Js_send_keys {
	WebDriver driver;
	JavascriptExecutor js;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/ref=nav_logo");
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 1)
	public void sendKeysByJsTest() throws InterruptedException {
		WebElement task1 = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		js.executeScript("arguments[0].value='ps4'", task1);
		Thread.sleep(2000);
		WebElement task2 = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
		js.executeScript("arguments[0].click()", task2);
		Thread.sleep(2000);
		WebElement task4 = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		js.executeScript("arguments[0].value='ps5'", task4);
		Thread.sleep(2000);
		WebElement task5 = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
		js.executeScript("arguments[0].click()", task5);
		Thread.sleep(2000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}