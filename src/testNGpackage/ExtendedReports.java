package testNGpackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
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

public class ExtendedReports {
	WebDriver driver;
	String url = "https://www.facebook.com";
	ExtentSparkReporter reporter;
	ExtentTest test;
	ExtentReports extent;
	
	@BeforeTest
	public void beforeTest() {
		
		reporter = new ExtentSparkReporter("./Reports/report1.html");
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
	public void setUp() {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void titleVerification() throws IOException, InterruptedException{
		test = extent.createTest("Title verification");
		String expectedTitle = "Facebook";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle,actualTitle );
		Thread.sleep(4000);
	}
	
	@Test
	public void buttonVerification() throws IOException{
		test = extent.createTest("Button verification");
		WebElement buttonSignin = driver.findElement(By.xpath("//button[@name = 'login']"));
		String buttonText = buttonSignin.getText();
		Assert.assertEquals(buttonText, "Log in");
	}
	
	@Test 
	public void pageSourceTest() throws IOException {
		test = extent.createTest("Pagesource test");
		boolean pagesource = driver.getPageSource().contains("facebook");
		Assert.assertTrue(pagesource);
		
	}
	
	@Test 
	public void buttonVisibility() {
		
		test = extent.createTest("Button Availability test");
		boolean buttonAvailability = driver.findElement(By.xpath("//button[@name = 'login']")).isDisplayed();
		Assert.assertTrue(buttonAvailability);
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
	}
	
	@AfterMethod
	public void browserClose(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test case failed is: "+result.getName());
			test.log(Status.FAIL, "Test case failed is: "+result.getThrowable());
			String pathScreenshot = ExtendedReports.screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(pathScreenshot);
		}
		
		else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test case skipped is: "+result.getName());
						
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test case passed is: "+result.getName());
		}
		
	}

	static String screenshotMethod(WebDriver driver, String screenshotpic) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotDestination = "./Screenshot/"+screenshotpic + ".png";
		FileHandler.copy(src, new File(screenshotDestination));
		return screenshotDestination;
	}

}
