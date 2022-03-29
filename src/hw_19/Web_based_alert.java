package hw_19;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Web_based_alert {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://enthrallit.com/selenium/");
		Thread.sleep(4000);
	}

	@Test(enabled = false, priority = 1, invocationCount = 1)
	public void webAllertAccept() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()=\"Alert\"]")).click();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		System.out.println("The text on the allert is " + alert.getText());
		alert.accept();
	}

	@Test(enabled = true, priority = 2, invocationCount = 1)
	public void webAllertDismiss() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()=\"Alert\"]")).click();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		System.out.println("The text on the allert is " + alert.getText());
		alert.dismiss();
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}