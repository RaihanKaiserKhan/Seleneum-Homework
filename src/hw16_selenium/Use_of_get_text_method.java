package hw16_selenium;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_get_text_method {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/ref=nav_logo");
		Thread.sleep(2000);
	}

	@Test(enabled = true, priority = 1)
	public void getTextMethodTest() throws InterruptedException {
		WebElement object = driver.findElement(By.xpath("//span[text()=\"Returns\"]"));
		Thread.sleep(2000);
		object.getText();
		System.out.println("The text of the button is :" + object.getText());
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}