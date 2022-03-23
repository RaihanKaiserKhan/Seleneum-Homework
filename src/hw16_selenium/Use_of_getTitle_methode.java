package hw16_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_getTitle_methode {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www1.nyc.gov/site/dcas/about/citywide-administrative-services-newsletter-sign-up.page");
		Thread.sleep(10000);
	}

	@Test(enabled = true, priority = 1)
	public void getTitleTest() {
		driver.getTitle();
		System.out.println("The title of the page is :" + driver.getTitle());
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}