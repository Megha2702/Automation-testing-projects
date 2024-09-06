package testNGpackage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandleTest2 {
	WebDriver driver;
	String url = "http://demo.guru99.com/popup.php";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void handleWindowTest() throws InterruptedException {
		
		//To get the parent window ie., the current window https://demo.guru99.com/popup.php.
		String parentWindow =  driver.getWindowHandle();
		System.out.println("The title of the parent window : "+driver.getTitle());
		WebElement clickButton = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		clickButton.click();
		
		//To get the child window https://demo.guru99.com/articles_popup.php.
		Set<String> childWindow = driver.getWindowHandles();
		
		for (String handle : childWindow) {
			//Check if the window is not parent window then switch to the child window.
			if(!handle.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				WebElement inputEmail = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input[1]"));
				inputEmail.sendKeys("megha@gmail.com");
				//driver.close();
			}
			//Finally switch to the parent window.
			driver.switchTo().window(parentWindow);
		}
		
		
		
	}
}
