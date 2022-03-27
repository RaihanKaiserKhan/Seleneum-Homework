package HW_18_selenium;

import java.awt.Dimension;
import java.lang.reflect.WildcardType;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_implicit_wait_pageload_method_by_enter_key {
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
	public void implicitlyWaitAndPageLoadMethodTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("ps4", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("ps5", Keys.ENTER);
		Thread.sleep(2000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}