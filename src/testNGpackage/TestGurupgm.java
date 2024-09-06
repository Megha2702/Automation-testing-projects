package testNGpackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestGurupgm {

	WebDriver driver;
	String url = "https://demo.guru99.com/test/simple_context_menu.html";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	@Test
	public void testRightclick() {
		Actions actions = new Actions(driver);
		WebElement rightClickButton = driver.findElement(By.xpath("//span[text()='right click me']"));
        actions.contextClick(rightClickButton).perform();
                   

        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        WebElement editOption = driver.findElement(By.xpath("//span[contains(text(),'Edit')]"));
        actions.click(editOption).perform();
        Alert alertEdit = driver.switchTo().alert();
        System.out.println("Alert text: " + alertEdit.getText());
        alertEdit.accept(); 
        
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
        actions.doubleClick(doubleClickButton).perform();
    
        Alert doubleClickAlert = driver.switchTo().alert();
        System.out.println("Double-click Alert text: " + doubleClickAlert.getText());
        doubleClickAlert.accept(); 


	}
	
	 @AfterTest
	    public void tearDown() {
	        // Close the browser
	       // driver.quit();
	    }
}
