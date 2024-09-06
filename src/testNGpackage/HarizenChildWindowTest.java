package testNGpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HarizenChildWindowTest {
	WebDriver driver;
	String url = "https://manjushablog.harizenitsolutions.se/";
	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	public void testblog() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
		WebElement getintouchButton = driver.findElement(By.xpath("//a[normalize-space()='Get In Touch']"));
		wait.until(ExpectedConditions.elementToBeClickable(getintouchButton)).click();
	}
}
