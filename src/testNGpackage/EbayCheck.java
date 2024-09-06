package testNGpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EbayCheck {
WebDriver driver;
String url = "https://ebay.com";
@BeforeTest
public void setUp() {
	driver = new ChromeDriver();
	driver.get(url);
	
}

@Test
public void mouseHover() {
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(30));
	Actions actions = new Actions(driver);
	WebElement electronicsMenu = driver.findElement(By.linkText("Electronics"));
	actions.moveToElement(electronicsMenu).perform();
	
	
	WebElement smartphones = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[2]/div[2]/div[1]/nav[1]/ul/li[1]/a"));
	wait.until(ExpectedConditions.visibilityOf(smartphones)).click();
	
	
//	if (driver.getTitle().contains("Cell Phones & Smartphones")) {
//       System.out.println("Successfully navigated to Cell Phones & Smartphones section.");
//   } else {
//        System.out.println("Navigation failed.");
//     }
	
}

}
