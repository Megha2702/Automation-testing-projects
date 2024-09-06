package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FbloginPage {
WebDriver driver;

//Setting element locators
By fbemail = By.id("email");
By fbpassword = By.id("pass");
By fbloginbutton = By.name("login");

//Constructor
public FbloginPage(WebDriver driver) {
	this.driver = driver;
}

//methods:
//Method1 :setting values for the elements
public void setValues(String password, String email) {
	
	driver.findElement(fbemail).sendKeys(email);
	driver.findElement(fbpassword).sendKeys(password);
	
}

//Method2: click on the login button
public void clickLogin() {
	driver.findElement(fbloginbutton).click();
}
}
