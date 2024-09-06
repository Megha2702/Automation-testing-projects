package testNGpackage;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RishiIndiaTesting {
	
	WebDriver driver;
	
	String url = "https://rishiherbalindia.linker.store/";
	
	@BeforeTest
	public void SetUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void test() throws IOException, InterruptedException{
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		String title = driver.getTitle();
		System.out.println("The website title is :" +title);
		String expectedTitle = "Rishi Herbal India";
		if(title.equals(expectedTitle)) {
			System.out.println("Title is same as expected title: "+expectedTitle);
		}
		else {
			System.out.println("Title is not same as expected!");
		}            
		
		//Agriculture link is present or not
		WebElement agriculture = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[7]/a"));
		if(agriculture.isDisplayed()) {
			System.out.println("Page contains agriculture link.");
		}
		else {
			System.out.println("page not contains agriculture link.");
		}

        //Screenshot
        
        File screenshot = agriculture.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("./Screenshot/screenshotAgriculture.png"));
        System.out.println("Screenshot has been taken.");
        Thread.sleep(2000);
        
        //click Health
        WebElement healthLink = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[2]/a")); 
        healthLink.click();
        System.out.println("Health link clicked.");
        
        WebElement sortDropdown = driver.findElement(By.xpath("//*[@id=\"input-sort\"]"));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Price (Low > High)");
             
	}
	
	@Test
    public void testAddProductToWishlist() throws InterruptedException {
        
		   // Search for "baby products"
	       WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search Product']"));
	       searchBox.sendKeys("baby products");
	       System.out.println("The product search has been done for baby products.");
	       WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
	       searchButton.click();
	       System.out.println("Searching made successful!");

	       // Select the baby product in the search results
	       WebElement firstProductLink = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div/div[1]/div/a"));
	       firstProductLink.click();

	       // Add the product to the wishlist
	       WebElement addToWishlistButton = driver.findElement(By.xpath("//*[@id=\"prod_cont\"]/div/div[4]/button[1]"));
	       addToWishlistButton.click();
	       System.out.println("The product successfully added to the wish list.");
	       
	         
    }
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
