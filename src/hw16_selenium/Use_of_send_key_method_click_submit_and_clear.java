package hw16_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_send_key_method_click_submit_and_clear {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/ref=nav_logo");
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 1)
	public void sendKeyMethodTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("ps4");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("ps5");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(2000);
	}
@AfterTest
	public void tearUp() {
		driver.quit();
	}
}