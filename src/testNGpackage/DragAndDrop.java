package testNGpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {

	WebDriver driver;
	String link = "https://demo.guru99.com/test/drag_drop.html";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(link);
	}
	
	@Test
	public void dragAndDrop() throws InterruptedException {
		
		Actions act = new Actions(driver);
		
		WebElement bank = driver.findElement(By.xpath("//a[contains(text(),'BANK')]"));
		WebElement bankTarget = driver.findElement(By.id("bank"));
		act.dragAndDrop(bank, bankTarget).perform();
		Thread.sleep(2000);
	    
	    WebElement sales = driver.findElement(By.xpath("//a[contains(text(),'SALES')]"));
  	    WebElement salesTarget = driver.findElement(By.id("loan"));
        act.dragAndDrop(sales, salesTarget).perform();
        Thread.sleep(2000);
        
        WebElement amountBank = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
        WebElement amountBankTarget = driver.findElement(By.id("amt7"));
        act.dragAndDrop(amountBank, amountBankTarget).perform();
        
        WebElement amountSales = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
        WebElement amountSalesTarget= driver.findElement(By.id("amt8"));
        act.dragAndDrop(amountSales, amountSalesTarget).perform();
        
        if(driver.findElement(By.xpath("//*[@id=\"equal\"]/a")).isDisplayed()) {
        	System.out.println("The message displayed as perfect!");
        }
        else {
        	System.out.println("The message is not received as perfect.");
        }
        
        
	}
}
