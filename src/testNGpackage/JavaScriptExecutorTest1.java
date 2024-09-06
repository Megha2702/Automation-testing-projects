package testNGpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest1 {
	WebDriver driver;
	String url = "https:/www.amazon.in";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void jsExcecutorTest() throws InterruptedException {
		
		//Scroll down to the specific element.
		WebElement elementToScroll = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[5]/span"));
		JavascriptExecutor jsExecutor =  (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
		Thread.sleep(2000);
		
		//Get the value of a javascript variable
		String title = (String) jsExecutor.executeScript("return document.title;");
		System.out.println("Page title is: " + title);
		
		//Click on the button with JavaScript
		WebElement button = driver.findElement(By.xpath("//*[@id=\"CardInstanceHZzQAW-qlzDEIV8hNsMaVw\"]/div/div/a"));
		jsExecutor.executeScript("arguments[0].click();", button);
		
		
	}

}
