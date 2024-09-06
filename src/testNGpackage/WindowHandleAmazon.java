package testNGpackage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandleAmazon {

	WebDriver driver;
	String url = "https://www.amazon.in/";
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void testAmazonWindow() throws InterruptedException {
		
		
		//Search mobile phones
		WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		searchBar.sendKeys("Mobile phones", Keys.ENTER);
		
		//Verify the title
		String expectedTitle = "Amazon.in : Mobile phones";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle,"failed!");
	
		//Click the product in the results
		WebElement firstSearch = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
		firstSearch.click();
		
		//parent window
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window is: "+parentWindow);
		
		// child window
		Set<String> childWindow = driver.getWindowHandles();
		System.out.println("The child window is: "+childWindow);
		
		for (String handle : childWindow) {
			if(!handle.equalsIgnoreCase(parentWindow)) {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				//Switch to child window
				driver.switchTo().window(handle);
				
				//Scroll function using JavaScriptExecutor
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)", "");
				//Thread.sleep(3000);
				
				WebElement addCart = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']"));
				wait.until(ExpectedConditions.elementToBeClickable(addCart)).click();
				System.out.println("Product has been added to the cart.");
				
				WebElement cart = driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]"));
				wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
				
//				WebElement cartItem = driver.findElement(By.cssSelector("span.a-truncate-cut"));
//	            System.out.println("Product in cart: " + cartItem.getText());

				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}
}
