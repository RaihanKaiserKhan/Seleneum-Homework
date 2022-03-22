package hw16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_isDisplayed_method_by_Xpath {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(
				"https://my.ny.gov/sreg/Login?TYPE=33554433&REALMOID=06-8a7b34cc-d651-1012-95f2-839b4d430cb3&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=$SM$%2fwdO7d5Kur4lk9fsxycgLO8IjohxfiA4ELtAEcXEtl35DC%2fDk0PuUxRMyhgbQUvL&TARGET=$SM$HTTP%3a%2f%2fmy%2edmv%2eny%2egov%2fmydmv%3f_ga%3d2%2e42592805%2e1487758556%2e1647878005-1711279741%2e1647878005");
		Thread.sleep(2000);
	}

	@Test(enabled = true, priority = 1)
	public void loginModalHeaderTest() throws InterruptedException {
		boolean flag = driver.findElement(By.xpath("//div[@class=\"nygovimage\"]")).isDisplayed();
		Thread.sleep(2000);
		System.out.println("Is the modal displayed " + flag);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}