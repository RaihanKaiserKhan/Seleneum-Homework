package hw16_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_get_attribute_method {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(
				"https://www.americanexpress.com/en-us/account/login?DestPage=https%3A%2F%2Fglobal.americanexpress.com%2Fdashboard%3Finav%3Dmenu_myacct_acctsum%26appv5%3Dfalse");
		Thread.sleep(2000);
	}

	@Test(enabled = true, priority = 1)
	public void getAttributeMethodSTest() throws InterruptedException {
		String value1 = driver.findElement(By.xpath("//button[@class=\"btn-fluid margin-0-b\"]")).getAttribute("id");
		String value2 = driver.findElement(By.xpath("//button[@class=\"btn-fluid margin-0-b\"]")).getAttribute("class");
		String value3 = driver.findElement(By.xpath("//button[@class=\"btn-fluid margin-0-b\"]")).getAttribute("type");
		Thread.sleep(2000);
		System.out.println("The value of id is :" + value1);
		System.out.println("The value of class attribute is :" + value2);
		System.out.println("The value of type attribute  is :" + value3);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}