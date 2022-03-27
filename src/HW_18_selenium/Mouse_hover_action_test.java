package HW_18_selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mouse_hover_action_test {
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

	@Test(enabled = true, priority = 1, invocationCount = 1)
	public void mouseHoverOnMyEbay() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement myEbayButton = driver
				.findElement(By.xpath("//a[@class=\"gh-eb-li-a gh-rvi-menu\" and @title=\"My eBay\" ]"));
		actions.moveToElement(myEbayButton).build().perform();
		Thread.sleep(5000);
		System.out.println("The text on the element is " + myEbayButton.getText());
	}

	@Test(enabled = true, priority = 2, invocationCount = 2)
	public void mouseHoverOnWatchList() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement watchList = driver.findElement(By.xpath("//a[@class=\"gh-eb-li-a gh-rvi-menu watchlist-menu\"]"));
		actions.moveToElement(watchList).build().perform();
		Thread.sleep(5000);
		System.out.println("The text on the element is " + watchList.getText());
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}