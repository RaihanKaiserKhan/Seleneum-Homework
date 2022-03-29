package hw_19;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class How_to_find_hidden_element {
	WebDriver driver;
	JavascriptExecutor js;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://enthrallit.com/selenium/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Thread.sleep(5000);

	}

	@Test(enabled = false, priority = 2, invocationCount = 1)
	public void findingHiddenElementWrong() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id=\"hide-textbox\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"displayed-text\"]"));
		Thread.sleep(5000);
	}

	@Test(enabled = true, priority = 1, invocationCount = 1)
	public void findingHiddenElement() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id=\"formButton\"]")).click();
		WebElement text = driver
				.findElement(By.xpath("//input[@class=\"form-control\" and @placeholder=\"Hide/Show Example\"]"));
		js.executeScript("arguments[0].value='Hello' ", text);
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}