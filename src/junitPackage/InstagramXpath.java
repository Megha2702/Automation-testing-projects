package junitPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstagramXpath {
	ChromeDriver driver;
	@Before
	public void setUp() {
		//launch browser
		driver = new ChromeDriver();
		driver.get("https://instagram.com");
	}
	
	@Test
	public void testProcess() throws InterruptedException {
		Thread.sleep(3000);
		// Maximize Screen
		driver.manage().window().maximize();
		//xpath
		WebElement email = driver.findElement(By.xpath("//input[@name='username']"));
		email.sendKeys("abcd123@gmail.com");
		email.sendKeys(Keys.ENTER);
		//email.submit();
		/*
		 * WebElement password =
		 * driver.findElement(By.xpath("//input[@name='password']"));
		 * password.sendKeys("hello1234"); password.submit();
		 */
	}
	@After
	public void exitBrowser() {
		//driver.exit();
	}

}
