package hw16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_send_key_method {
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
		Thread.sleep(1000);
	}

	@Test(enabled = true, priority = 1)
	public void sendKeyMethodTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id=\"eliloUserID\"]")).sendKeys("Raihan Khan");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id=\"eliloPassword\"]")).sendKeys("RaihanKhan");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id=\"loginSubmit\"]")).click();
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}