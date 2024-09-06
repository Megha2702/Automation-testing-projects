package junitPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPgm {
	ChromeDriver driver;
	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		//driver.get("https://www.rediff.com");
	}
	
	@Test 
	public void test() {
		WebElement searchBar = driver.findElement(By.xpath("//textarea[@name = 'q']"));
		searchBar.sendKeys("JUnit", Keys.ENTER);
		//driver.findElement(By.xpath("//table[@id = 'tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys("abcd@gmail.com",Keys.ENTER);
	}
	
	@After
	public void after() {
		//driver.quit();
	}
	
}
