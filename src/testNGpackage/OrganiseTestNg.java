package testNGpackage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrganiseTestNg {
	ChromeDriver driver;
	private String link;
	@BeforeTest(alwaysRun = true)
	public void setUp() {
		driver = new ChromeDriver();	
		System.out.println("Hello, this is set up.");
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void urlLoading() throws InterruptedException{
		Thread.sleep(2000);
		String link = "https://www.amazon.in";
		driver.get(link);
		System.out.println("Amazon page has been loaded!");
		driver.manage().window().maximize();
		
	}
	
	@Test(groups = "sanity" ,priority = 1)
	public void searchProduct() {
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("laptops",Keys.ENTER);
		System.out.println("Search bar has found.");
		WebElement hpBrandFilter = driver.findElement(By.xpath("//span[text()='HP']"));
        hpBrandFilter.click();
		
	}
	
	@Test(enabled = false)
	public void selection() {
//		Thread.sleep(2000);
//		WebElement hpBrandFilter = driver.findElement(By.xpath("//span[text()='HP']"));
//        hpBrandFilter.click();
//		driver.navigate().back();
		System.out.println("selected brand HP.");
	}
	
	@Test(groups = {"sanity", "regression"}, priority = 2)
	public void hamburgerMenu() throws InterruptedException {
		Thread.sleep(2000);
		WebElement hamburgerMenu = driver.findElement(By.xpath("//a[@id = \"nav-hamburger-menu\"]/i[1]"));
		hamburgerMenu.click();
		System.out.println("The hamburger menu has found out!");
		
	}
	
	@Test(priority = 3)
	public void navigateBack() {
		driver.navigate().back();
	}
	
	@Test(priority = 4)
	public void findLinks()
	{
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("The number of list tags available:"+li.size());
		for (WebElement link : li) {
			
			String linkText = link.getText();
			String attributeName = link.getAttribute("href");
			System.out.println("Link text is:"+linkText+".........And the link is: "+attributeName);
		}
	}
	
	@Test(priority = 5)
	public void responseCode() throws URISyntaxException, IOException {
		
		URI ob = new URI(link);
		HttpURLConnection connection = (HttpURLConnection)ob.toURL().openConnection();
		connection.connect();
		if(connection.getResponseCode() == 200) {
			System.out.println("Connection is succesful"+link);
		}
		else if(connection.getResponseCode() == 404) {
			System.out.println("It is a broken link"+link);
		}
	}
	
	@AfterMethod
	public void takeScreenshots() throws IOException {
		File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File("./Screenshot/screenshotAmazonpage.png"));
		System.out.println("Screenshot taken for the page.");
		
		WebElement hamburgerMenuScreenshot = driver.findElement(By.xpath("//a[@id = \"nav-hamburger-menu\"]/i[1]"));
		File menu = hamburgerMenuScreenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(menu, new File("./Screenshot/hamburgerMenu.png"));
		System.out.println("Hamburger menpu screenshot has taken.Please check in the folder of screenshot.");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
