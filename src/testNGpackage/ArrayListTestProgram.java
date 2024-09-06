package testNGpackage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayListTestProgram {

	WebDriver driver;
	String url = "https://www.google.com";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void testWindow() throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://seematti.com/");
		WebElement newArrival = driver.findElement(By.xpath("//*[@id=\"nav-menu-item-57947\"]/a/span/span[2]"));
		newArrival.click();
		WebElement shopByCategory = driver.findElement(By.xpath("//*[@id=\"nav-menu-item-6972\"]/a/span/span"));
		shopByCategory.click();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://kalyansilks.com/");
		Thread.sleep(2000);
		WebElement searchbar = driver.findElement(By.xpath("//input[@placeholder='What are you looking for?']"));
		searchbar.sendKeys("Sarees",Keys.ENTER);
//		WebElement filter = driver.findElement(By.xpath("//div[@class='drop_head']"));
//		Select filterByPrice = new Select(filter);
//		filterByPrice.selectByVisibleText("Price");
		WebElement signin = driver.findElement(By.xpath("//p[contains(@class,'font-normal font-body text-white text-[0.8rem] drop-down-title')]"));
		signin.click();
		
		//Switch to the second window using arraylist class.
		ArrayList<String> windowOrder = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowOrder.get(1));
	}
}
