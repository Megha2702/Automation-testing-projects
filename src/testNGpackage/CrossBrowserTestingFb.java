package testNGpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestingFb {
	
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Chrome browser opened successfully!");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox browser opened successfully!");
		}
		else  {
			driver = new EdgeDriver();
			System.out.println("Edge browser opened successfully!");
		}
				
	}
	
	@Test
	public void fbBrowser() {
		driver.get("https://www.facebook.com");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
