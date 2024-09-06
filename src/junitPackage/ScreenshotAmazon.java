package junitPackage;

import java.io.File;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotAmazon {
	ChromeDriver driver;
	@Before
	public void setUpAmazon() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
	}
	
	@Test
	public void amazonScreenshots() throws IOException {
		//For large screenshots.
		File screenshotPage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotPage, new File("./Screenshot/amazonscreenshot.png"));
		
		//Mini screenshot
		WebElement signIn = driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span"));
		File loginButton = signIn.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(loginButton, new File("./Screenshot/loginbutton.png"));
		
		WebElement searchbar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		File searchBar = searchbar.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(searchBar, new File("./Screenshot/searchbar.png"));
	}
	
	@Test
	public void testAlert() throws Exception{
		//How to get alert in Web driver?
//		WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
//		email.sendKeys("abcd@gmail.com", Keys.ENTER);
	
//		WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
//		password.sendKeys("abcd123",Keys.ENTER);
//		
//		WebElement buttonLogin = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
//		buttonLogin.click();
//		
//		Alert a = driver.switchTo().alert();
//		System.out.println(a.getText());
//		a.accept();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('You got an alert message!');");

        // Switch to the alert
        Alert alert = driver.switchTo().alert();
        
     // Print the alert text
        System.out.println("Alert text: " + alert.getText());
        
     // Accept the alert
        alert.accept();
      

        // Optionally, interact with other elements
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        if (logo.isDisplayed()) {
            System.out.println("The Amazon logo is displayed.");
        } else {
            System.out.println("The Amazon logo is not displayed.");
        }
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
