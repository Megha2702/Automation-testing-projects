package testNGpackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datadriventest {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
		Thread.sleep(3000);
	}
	
	//@SuppressWarnings("resource")
	@Test
	public void dataDrivenTest() throws IOException {
		
		FileInputStream ob = new FileInputStream("D:\\Software_testing\\datadriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(ob); 
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int r = sheet.getLastRowNum();
		
			for(int i = 1; i<=r; i++) {
				String email = sheet.getRow(i).getCell(0).getStringCellValue();
				String password =sheet.getRow(i).getCell(1).getStringCellValue();
				System.out.println("Email is : "+email+" Password is: "+password);
				
				WebElement emailFb = driver.findElement(By.id("email"));
				WebElement passwordFb = driver.findElement(By.id("pass"));
				
				emailFb.clear();
				emailFb.sendKeys(email);
				passwordFb.clear();
				passwordFb.sendKeys(password);
				
				WebElement signIn = driver.findElement(By.name("login"));
				signIn.click();
				//driver.navigate().refresh();
//				String actualUrl = driver.getCurrentUrl();
//				String expectedUrl = "https://www.facebook.com/home";
//				if(actualUrl.equals(expectedUrl)) {
//					System.out.println("Test has been passed!");
//				}
//				else {
//					System.out.println("Test has been failed.Try again!");
//				}
			}
		}
	}
		

