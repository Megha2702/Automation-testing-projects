package junitPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffAutomate {
ChromeDriver driver;

@Before
public void setUpRediff() {
	driver = new ChromeDriver();
	driver.navigate().to("https://register.rediff.com/register/register.php?FormName=user_details");
		
}
@Test
public void automateRediff() throws InterruptedException {
	WebElement name =driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[3]/td[3]/input"));
	name.sendKeys("Megha Mohan", Keys.ENTER);
	Thread.sleep(3000);
	
	WebElement email = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));
	email.sendKeys("meghamohan123", Keys.ENTER);
	Thread.sleep(3000);
	
	WebElement availability = driver.findElement(By.xpath("//tbody/tr[7]/td[3]/input[2]"));
	availability.click();
	
	WebElement password = driver.findElement(By.xpath("//input[contains(@name,'passwd')]"));
	password.sendKeys("Evaanadai506", Keys.ENTER);
}
@After
public void tearDown() {
	//driver.quit();
}
}
