package HW_18_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 

public class Drop_down_by_selected_by_methods {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	@Test(enabled = false, priority = 1)
	public void dropDownBySelectByIndexTest() throws InterruptedException {
		WebElement dropDown = driver.findElement(By.xpath("//select[@id=\"gh-cat\"]"));
		Select select = new Select(dropDown);
		select.selectByVisibleText(null)
		Thread.sleep(3000);
	}

	@Test(enabled = false, priority = 2)
	public void dropDownBySelectByVisibleTest() throws InterruptedException {
		WebElement dropDown = driver.findElement(By.xpath("//select[@id=\"gh-cat\"]"));
		Select select = new Select(dropDown);
		select.selectByVisibleText("Books");
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 3)
	public void dropDownBySelectByValue() throws InterruptedException {
		WebElement dropDown = driver.findElement(By.xpath("//select[@id=\"gh-cat\"]"));
		Select select = new Select(dropDown);
		select.selectByValue("15032");
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}