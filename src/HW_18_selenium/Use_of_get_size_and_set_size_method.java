package HW_18_selenium;

import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Use_of_get_size_and_set_size_method {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rksun\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.com/ref=nav_logo");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 1, invocationCount = 1)
	public void sizeOfWindowTest() throws InterruptedException {
		driver.manage().window().fullscreen();
		Thread.sleep(2000);
		System.out.println("Size of screen is " + driver.manage().window().getSize());
		// This test is to find out the screen size of the display.
	}

	@Test(enabled = false, priority = 1, invocationCount = 2)
	public void setSpecificSizeOfWindowTest() throws InterruptedException {
		Dimension dimention = new Dimension(800, 500); 
		// This "Dimension" class lets us set our windows to a specific size with help of setSize(). Maximum for my display is (1280,720).
		driver.manage().window().setSize(dimention);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.manage().window().setSize(dimention);
		Thread.sleep(1000);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}