package hw16_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_isSelect_method {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.discover.com/");
	}

	@Test(enabled = true, priority = 1)
	public void checkBoxTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id=\"id-checkbox-content\"]")).click();
		Thread.sleep(2000);
		boolean checkBoxSelected = driver.findElement(By.xpath("//input[@id=\"id-checkbox-content\"]")).isSelected();
		System.out.println("Is the check box selected? Ans: " + checkBoxSelected);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}