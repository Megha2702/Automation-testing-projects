package junitPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateGoogleSearch {
	ChromeDriver driver;
	
	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}
	@Test
	public void test() {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("java",Keys.ENTER);
		
		//searchBox.submit();
	}
	@After
	public void after() {
//	if (driver != null) {
//		driver.quit();
	//}
	}

}
