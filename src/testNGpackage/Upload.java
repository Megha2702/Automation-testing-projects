package testNGpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Upload {
WebDriver driver;
String url = "https://demo.guru99.com/test/upload/";
@BeforeTest
public void setUp() throws InterruptedException {
	driver = new ChromeDriver();
	driver.get(url);
}

@Test
public void testFile() throws InterruptedException {
	
	WebElement fileUp = driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]"));
	fileUp.sendKeys("D://Software_testing//Answers-sql.docx");
	Thread.sleep(2000);
	
	WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"terms\"]"));
	checkbox.click();
	
	WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submitbutton\"]"));
	submitButton.click();
	System.out.println("The file has been successfully uploaded!");
}
}

