package junitPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testpgm1 {
ChromeDriver driver;
@Before
public void before() {
	driver = new ChromeDriver();
	driver.get("https://facebook.com");
	
}
@Test 
public void test() {
	driver.findElement(By.id("email")).sendKeys("megha@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("abcdef");
	driver.findElement(By.name("login")).click();
}
@After
public void after() {
driver.quit();

}
}
