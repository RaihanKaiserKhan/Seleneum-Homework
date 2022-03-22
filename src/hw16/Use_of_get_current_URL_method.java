package hw16;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_get_current_URL_method {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/ref=nav_logo");
		Thread.sleep(5000);
	}

	@Test(enabled = true, priority = 1)
	public void getCurrentURLTestTest() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()=\"Returns\"]")).click();
		Thread.sleep(10000);
		driver.getCurrentUrl();
		System.out.println("The current url is :" + driver.getCurrentUrl());
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}