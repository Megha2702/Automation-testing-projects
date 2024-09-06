package testNGpackage;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayListPgm {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
	}
	@Test
	public void testHandlewindow() {
		System.out.println("The title is:"+driver.getTitle());
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.ebay.com");
		System.out.println("The title is: "+driver.getTitle());
		
		ArrayList<String> windowDetails = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowDetails.get(2));
		System.out.println("The title is: "+driver.getTitle());
	}
}
