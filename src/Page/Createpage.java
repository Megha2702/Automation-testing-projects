package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Createpage {

	WebDriver driver;
	
	By signupButton = By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div[2]/div/div/span/a");
	By createpageText = By.xpath("//*[contains(text(),'Create a Page')]");
	
	public Createpage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isTextDisplayed() {
		boolean text = driver.findElement(createpageText).isDisplayed();
		if(text) {
			System.out.println("The expected text is found");
		}
		else {
			System.out.println("The expected text not found");
		}
		
		return text;
		
		}
	
	public void buttonClick() {
		driver.findElement(signupButton).click();
	}
}
