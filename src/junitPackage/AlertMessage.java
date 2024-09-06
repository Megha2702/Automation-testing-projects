package junitPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertMessage {
	ChromeDriver driver;
	
@Before
public void setUp() {
	driver = new ChromeDriver();
	driver.get("https://demoqa.com/alerts");
	
}

@Test
public void testAlert() throws InterruptedException {
	WebElement alertButton = driver.findElement(By.xpath("//*[@id=\"promtButton\"]"));
	alertButton.click();
	Thread.sleep(2000);
	Alert a = driver.switchTo().alert();
	System.out.println(a.getText());
	a.accept();
}
@After
public void tearDown() {
	driver.quit();
	
}
}
