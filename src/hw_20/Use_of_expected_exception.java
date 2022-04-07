package hw_20;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Use_of_expected_exception {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() throws InterruptedException {
		WebDriverManager.chromedriver().browserVersion(null).setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/ref=nav_logo");
		Thread.sleep(3000);
	}

	@Test(enabled = false, expectedExceptions = ArithmeticException.class)
	public void testWithExpectedException() {
		int i = 6 / 0;
	}

	@Test(enabled = false, priority = 1, threadPoolSize = 2, invocationCount = 2)
	public void expectedExcetionTest() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()=sasas\"Rerns\"]")).click();
		Thread.sleep(5000);
		driver.getCurrentUrl();
		System.out.println("The current url is :" + driver.getCurrentUrl());
	}

	@Test(expectedExceptions = org.openqa.selenium.NoSuchElementException.class, threadPoolSize = 2, invocationCount = 2)
	public void searchButton() throws InterruptedException {
		driver.findElement(By.id("nav-search-submit-buttonXXX")).click();
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}