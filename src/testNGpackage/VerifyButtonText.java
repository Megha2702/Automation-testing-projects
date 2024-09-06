package testNGpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyButtonText {
	 WebDriver driver;
	 String baseUrl = "https://register.rediff.com/register/register.php?FormName=user_details";
	 @BeforeTest
	 public void setUp() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(baseUrl);
	 }
	 @Test
	 public void test() {
		 WebElement checkAvailabilityButton = driver.findElement(By.xpath("//input[@value='Check availability']"));
		 String actualButtonText = checkAvailabilityButton.getAttribute("value");
		 String expectedButtonText = "Check availability";
//		 Assert.assertEquals(actualButtonText, expectedButtonText, "Button text does not match!");
		 if(actualButtonText.equalsIgnoreCase(expectedButtonText)) {
			 System.out.println("Test passed!");
		 }
		 else {
			 System.out.println("Test failed");
		 }
		 
	 }

}
