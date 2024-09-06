package junitPackage;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffAttribute {
	ChromeDriver driver;
	String urlString = "https://register.rediff.com/register/register.php";
	@Before
	public void setUpRediff() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php");
		
		
	}
	@Test
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links on the page: " + links.size());
		for (WebElement link : links) {
            String linkText = link.getText();
            String linkHref = link.getAttribute("href");
            System.out.println("Link text is: " + linkText);
            System.out.println("Link href is: " + linkHref);
            System.out.println();
        }
		
	}
	@Test 
	public void responseCodeCheck() {
		
		
		
	}
	@After
	public void tearDown() {
		//driver.quit();
	}

}
