package junitPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLocators {
	 	ChromeDriver driver;
	    WebDriverWait wait;

	    @Before
	    public void setUp() {
	      
	        driver = new ChromeDriver();
	       
	        driver.get("https://facebook.com");
	    }

	    @Test
	    public void testElementClick() {
	    	//maximize screen
	    	driver.manage().window().maximize();
	        // Locators
	    try {
	        driver.findElement(By.id("email")).sendKeys("evaan@gmail.com");
	        driver.findElement(By.id("pass")).sendKeys("acd343345");
	        driver.findElement(By.name("login")).submit();
	        driver.findElement(By.name("login")).click();
	    } catch(Exception e) {
	    	System.out.println("Exception caught");
	    	System.out.println(e.getMessage());
	    }
	        	        
	    }

	    @After
	    public void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
	    }
	}