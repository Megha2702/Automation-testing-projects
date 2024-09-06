package testNGpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wait {

	WebDriver driver;
	String url = "https://www.amazon.in";
	@BeforeTest
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.get(url);
				
	}
	
	@Test
	public void testAndWait() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement todaysDeal =  driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[5]"));
		todaysDeal.click();
		
		WebElement dealOfDay = driver.findElement(By.xpath("//*[@id=\"anonCarousel1\"]/ol/li[2]/button"));
		wait.until(ExpectedConditions.visibilityOf(dealOfDay)).click();
		
	}
	
}
