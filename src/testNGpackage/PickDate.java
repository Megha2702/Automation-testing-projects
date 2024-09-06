package testNGpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PickDate {
	WebDriver driver;
	String url = "https://www.trivago.com/";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void testdatepick() {
		WebElement search = driver.findElement(By.xpath("//input[@id='input-auto-complete']"));
		search.sendKeys("Stockholm", Keys.ENTER);
		
		WebElement dateCheckin = driver.findElement(By.xpath("//input[@data-testid='checkin-input']"));
		dateCheckin.click();
		selectDate("29", "2024", "August");
		
		WebElement dateCheckout = driver.findElement(By.xpath("//input[@data-testid='checkout-input']"));
		dateCheckout.click();
		selectDate("23", "2024", "September");
		
		WebElement searchButton = driver.findElement(By.xpath("//button[@data-testid='search-button']"));
        searchButton.click();
	}
	
	public void selectDate(String day, String month, String year) {
		
		while(true) {
			WebElement monthElement = driver.findElement(By.xpath("//div[@data-testid='month-title']"));
			String display = monthElement.getText();
			if(display.equals(month+ " " +year)) {
				break;
			}
			
			WebElement nextButton = driver.findElement(By.xpath("//button[@data-testid='datepicker-next-button']"));
			nextButton.click();
		}
		String dateXpath = String.format("//button[@data-testid='datepicker-calendar-day'][text()='%s']", day);
        WebElement dateElement = driver.findElement(By.xpath(dateXpath));
        dateElement.click();
		
	}
	
	@AfterTest
	public void tearDown() {
		//driver.close();
	}
}
