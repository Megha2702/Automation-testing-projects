package junitPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelection {

	ChromeDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}
	
	@Test
	public void selectDropdown() {
		//How to make a dropdown selection in selenium webdriver.
		WebElement day = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
		Select dayDetails = new Select(day);
		dayDetails.selectByValue("02");
		
		WebElement month = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
		Select monthDetails = new Select(month);
		monthDetails.selectByVisibleText("FEB");
				
		WebElement year = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]"));
		Select yearDetails = new Select(year);
		yearDetails.selectByVisibleText("2010");
		
		WebElement country = driver.findElement(By.id("country"));
		Select countryName = new Select(country);
		countryName.selectByVisibleText("Sweden");
		
		
		
	}
	@Test
	public void displayLogo() {
		//Check whether the logo is displayed or not.
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/table[1]/tbody/tr[1]/td[1]/img"));
		if (logo.isDisplayed()) {
            System.out.println("The Rediff logo is displayed .");
        } else {
            System.out.println("The Rediff logo is not displayed .");
        }
	
	}
	
	@Test
	public void radioButtonSelect() {
		//Check if the radio button is selected by default
		WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[1]"));
	    if(radioButton.isSelected()) {
	    	System.out.println("Radio button is selected .");
        } else {
            System.out.println("Radio button is not seleted .");
        }
	    
	    //Radio button selection from default value = male to female in the web page
	    driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]")).click();
	    }
	@Test
	public void buttonEnabled() {
		//Check if the button is enabled or not
		WebElement button = driver.findElement(By.xpath("//*[@id=\"Register\"]"));
	    if(button.isEnabled()) {
	    	System.out.println("Enabled button .");
        } else {
            System.out.println("not Enabled .");
        }
	    }
	
	
	@After
	public void tearDown() {
		//driver.quit();
		
	}
}
