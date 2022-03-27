package HW_18_selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_navigate_methods_by_sendkey {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.com/ref=nav_logo");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 1)
	public void navigateTest() throws InterruptedException {
		driver.navigate().to("https://www.facebook.com/"); // navigates to Facebook.com
		Thread.sleep(2000);
		driver.navigate().back(); // Navigates back to amazon.com
		Thread.sleep(2000);
		driver.navigate().forward(); // Navigates again to facebook.com
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}