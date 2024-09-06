package testNGpackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandleTest1 {

	WebDriver driver;
	String url = "https://www.amazon.in";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void windowHandle() throws InterruptedException {
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		search.sendKeys("laptops", Keys.ENTER);
		Set<String> windowhandles = driver.getWindowHandles();
		
		Iterator<String> iterator	= windowhandles.iterator();
		String parentwindow = iterator.next();
		System.out.println(parentwindow);
		
		String childwindow = iterator.next();
		System.out.println(childwindow);
		
		driver.switchTo().window(childwindow);
		Thread.sleep(2000);
		driver.switchTo().window(parentwindow);
		
		
	}
}
