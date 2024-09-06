package testNGpackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpAutoit {

	WebDriver driver;
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void main() throws InterruptedException {
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		Thread.sleep(3000);
		try {
			Runtime.getRuntime().exec("D:\\Software_testing\\a2.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
