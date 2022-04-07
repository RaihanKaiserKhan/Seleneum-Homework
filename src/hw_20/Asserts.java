package hw_20;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Asserts {
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

	@Test(enabled = false, priority = 1, invocationCount = 1)
	public void logoTestAssertTrue() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"twotabsearchtextbox\"]")));
		WebElement logo = driver.findElement(By.xpath("//a[@id=\"nav-logo-sprites\"]"));
		boolean flag = logo.isDisplayed();
		System.out.println("Is logo displayed? " + flag);
		Assert.assertTrue(true, "Logo is not displayed");
	}

	@Test(enabled = false, priority = 2, invocationCount = 1)
	public void assertEqual() {
		String expected = "Amazon.com. Spend less. Smile more.";
		String actual = driver.getTitle();
		System.out.println("The title of the web page is: " + actual);
		System.out.println("The expexted title is : " + expected);
		Assert.assertEquals(actual, expected, "Page title doesnt match");
	}

	@Test(enabled = true, priority = 2, invocationCount = 1)
	// Testing with logo & drop down button.
	public void softAssert() throws InterruptedException {
		SoftAssert st = new SoftAssert();
		st.assertTrue(true);
		WebElement logo = driver.findElement(By.xpath("//a[@id=\"nav-logo-sprites\"]"));
		boolean flag = logo.isDisplayed();
		System.out.println("Is logo displayed? " + flag); // Untill this code will run due to soft assert.
		WebElement dropDown = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
		Select select = new Select(dropDown);
		select.selectByIndex(500);
		Thread.sleep(3000);
		st.assertAll();
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}