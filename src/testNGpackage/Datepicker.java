package testNGpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class Datepicker {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.trivago.com");
	}
	
	@Test
	public void datePick()throws Exception{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[@id=\"overlay-root\"]/div/section/main/div/div/div/div[2]/div[1]/div/button/time"));

		datepickermethod("August 2024","29");
	}
	
	public void datepickermethod(String expectedMonth, String expectedDate) throws Exception {
		Thread.sleep(3000);
		String month = driver.findElement(By.xpath("")).click();
		System.out.println(month);
		if(month.equals(expectedMonth)) {
			System.out.println("Month is: "+month);
		}
		else {
			driver.findElement(By.xpath("")).click();
		}
	}
	
	List<WebElement> alldates = driver.findElements(By.xpath(""));
	for(WebElement dateElement: alldates) {
		String date = dateElement.getText();
		if(date.equals(expectedDate)) {
			System.out.println(date);
			dateElement.click();
			break;
		}
	}
	
	
}
