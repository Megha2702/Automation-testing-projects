package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Baseclass {
	public static WebDriver driver;
	 
	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		//driver.get("https://facebook.com");
		driver.get("https://www.instagram.com/");
		Thread.sleep(2000);
	}
}
