package hw_20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}

	@Test(enabled = true, priority = 1, invocationCount = 1, threadPoolSize = 1, timeOut = 5000)
	public void searchButtonByParent() throws InterruptedException {
		driver.findElement(
				By.xpath("//input[@id=\"nav-search-submit-button\"]//parent::span[@id=\"nav-search-submit-text\"]"))
				.click();
		Thread.sleep(2000);
	}

	@Test(enabled = true, priority = 2, invocationCount = 1, threadPoolSize = 1, timeOut = 5000)
	public void searchFieldByChild() throws InterruptedException {
		driver.findElement(By.xpath(
				"//div[@class=\"nav-search-field \"]//child::input[@class=\"nav-input nav-progressive-attribute\"]"))
				.sendKeys("PS5", Keys.ENTER);
		Thread.sleep(2000);
	}

	@Test(enabled = true, priority = 3, invocationCount = 1, threadPoolSize = 1, timeOut = 5000)
	public void shoppingCartByFollowingSibling() throws InterruptedException {
		boolean cart = driver
				.findElement(By.xpath(
						"//span[@id=\"nav-cart-count\"]//following-sibling::span[@class=\"nav-cart-icon nav-sprite\"]"))
				.isDisplayed();
		System.out.println("Is the shopping cart displayed? Ans:" + cart);
		Thread.sleep(2000);
	}

	@Test(enabled = true, priority = 4, invocationCount = 1, threadPoolSize = 1, timeOut = 5000)
	public void selectYourAddressByPrecedingSibling() throws InterruptedException {
		driver.findElement(By.xpath(
				"//span[@id=\"glow-ingress-line2\"]//preceding-sibling::span[@class=\"nav-line-1 nav-progressive-content\"]"))
				.click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}