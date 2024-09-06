package testNGpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginParameters {
ChromeDriver driver;

@BeforeMethod
public void setUp() {
	driver = new ChromeDriver();
	driver.get("https://www.facebook.com/?locale2=sv_SE&_rdr");
	driver.manage().window().maximize();
}
	
@Parameters({"username", "password"})	
@Test
public void testLogin(String username, String password) {
	WebElement usernameFacebook = driver.findElement(By.xpath("//*[@id=\"email\"]")); 
	usernameFacebook.sendKeys(username ,Keys.ENTER);
    WebElement passwordFacebook = driver.findElement(By.xpath("//*[@id=\"pass\"]")); 
    passwordFacebook.sendKeys(password ,Keys.ENTER);
//    WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"u_0_9_y6\"]")); 
//    loginButton.click();
      
	}

@AfterMethod
public void tearDown() {
    
    driver.quit();
}
}
