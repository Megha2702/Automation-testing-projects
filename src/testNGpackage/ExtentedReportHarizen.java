package testNGpackage;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentedReportHarizen {
	WebDriver driver;
	String url = "https://www.harizenitsolutions.se";
	ExtentSparkReporter reporter;
	ExtentTest test;
	ExtentReports extent;
	
	@BeforeTest
	public void beforeTest() {
		
		reporter = new ExtentSparkReporter("./Reports/report_harizen.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional test");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("testername", "Megha");
		extent.setSystemInfo("browser", "Chrome");
		extent.setSystemInfo("os", "Windows 11 Pro");
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void menuClickable() {
		test = extent.createTest("Menu clickable");
		WebElement home = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[1]/a"));
		home.click();
		System.out.println("home menu clicked!");
		WebElement courses = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/a"));
		courses.click();
		System.out.println("courses menu clicked!");
		WebElement services = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[3]/a"));
		services.click();
		System.out.println("services menu clicked!");
		WebElement testimonials = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[4]/a"));
		testimonials.click();
		System.out.println("testimonials menu clicked!");
		WebElement aboutUs = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[5]/a"));
		aboutUs.click();
		System.out.println("about us menu clicked!");
		WebElement contact = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[6]/a"));
		contact.click();
		System.out.println("contact menu clicked!");
		WebElement blog = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[7]/a"));
		blog.click();
		System.out.println("blog menu clicked!");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//Scroll function using JavaScriptExecutor
		
		//driver.switchTo().window("https://manjushablog.harizenitsolutions.se/");
		WebElement getintouchButton = driver.findElement(By.xpath("//a[normalize-space()='Get In Touch']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
		
		wait.until(ExpectedConditions.elementToBeClickable(getintouchButton)).click();
		
	}
	@Test
	public void logoClickable() {
		test = extent.createTest("Logo clickable");
		WebElement logo = driver.findElement(By.xpath("/html/body/header/div/span[1]"));
		logo.click();
		
	}
	
//	@Test
//	public void childWindowButton() {
//		String parentWindow = driver.getWindowHandle();
//		System.out.println("The parent window is:"+parentWindow);
//		
//		Set<String> childWindow = driver.getWindowHandles();
//		System.out.println("The child window is: "+childWindow);
//		for (String handle : childWindow) {
//			if(!handle.equalsIgnoreCase(parentWindow)) {
//				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//				driver.switchTo().window(handle);
//				
//				//Scroll function using JavaScriptExecutor
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("window.scrollBy(0,800)", "");
//				
//				WebElement getintouchButton = driver.findElement(By.xpath("//*[@id=\"wp--skip-link--target\"]/div[3]/div[1]/div/div/a"));
//				wait.until(ExpectedConditions.elementToBeClickable(getintouchButton)).click();
//				driver.close();
//			}
//			driver.switchTo().window(parentWindow);
//		}
//	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
	}
	
	
	@AfterMethod
	public void browserClose(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test case failed is: "+result.getName());
			test.log(Status.FAIL, "Test case failed is: "+result.getThrowable());
			
		}
		
		else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test case skipped is: "+result.getName());
						
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test case passed is: "+result.getName());
		}
		
	}
}
