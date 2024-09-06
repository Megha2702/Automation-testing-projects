package Test;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page.Createpage;

public class CreatepageTest {
	WebDriver driver;
	 
	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/pages/create/?ref_type=registration_form");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test
	public void testCreatePage() throws InterruptedException {
		
		Createpage page = new Createpage(driver);
		page.isTextDisplayed();
		page.buttonClick();
		Thread.sleep(2000);
		
	}
}
