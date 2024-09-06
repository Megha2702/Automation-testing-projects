package testNGpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RishiWebsite {
	WebDriver driver;
    String baseUrl = "https://rishiherbalindia.linker.store/";

    @BeforeClass
    public void setUp() {
        
        driver = new ChromeDriver();
    
        driver.manage().window().maximize();
       
        driver.get(baseUrl);
    }
    @Test(priority = 1)
    public void linkTest() throws InterruptedException {
    	Thread.sleep(2000);
    	WebElement all = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a"));
    	all.click();
    	WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"outOfStockFilter\"]"));
    	checkBox.click();
    	WebElement health = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[2]/a"));
    	health.click();
    	WebElement safety = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[3]/a"));
    	safety.click();
    	WebElement skin = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[4]/a"));
    	skin.click();
    	WebElement personal = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[5]/a"));
    	personal.click();
    	WebElement baby = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[6]/a"));
    	baby.click();
    	WebElement agriculture = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[7]/a"));
    	agriculture.click();
    	WebElement veterinary = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[8]/a"));
    	veterinary.click();
    	WebElement home = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[9]/a"));
    	home.click();
    	WebElement food = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[10]/a"));
    	food.click();
    	
    }

    
    @Test(priority = 2)
    public void testAddProductToWishlist() throws InterruptedException {
        // 1. Search for "baby products"
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search Product']"));
        searchBox.sendKeys("baby products");
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();

        // Wait for the search results to load
        Thread.sleep(3000); 

        // 2. Select the first baby product in the search results
        WebElement firstProductLink = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div/div[1]/div/a"));
        firstProductLink.click();

        // 3. Add to Wishlist
        WebElement addToWishlistButton = driver.findElement(By.xpath("//*[@id=\"prod_cont\"]/div/div[4]/button[1]"));
        addToWishlistButton.click();
       
    }

}
