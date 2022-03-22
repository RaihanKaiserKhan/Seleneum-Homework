package hw15_part_02_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_click_method_by_link_text {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www1.nyc.gov/site/dcas/about/citywide-administrative-services-newsletter-sign-up.page");
		Thread.sleep(5000);
	}

	@Test(enabled = true, priority = 1)
	public void mobileAppsTest() throws InterruptedException {
		driver.findElement(By.linkText("NYC Mobile Apps")).click(); // "NYC Mobile Apps" button
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}