package junitPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonMenu {
	ChromeDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		//driver.navigate().to("https://www.amazon.in");
       driver.get("https://www.amazon.in");
	}
	@Test
	public void amazonAutomate() throws InterruptedException {
		driver.manage().window().maximize();
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("mobile phones", Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement mobiles = driver.findElement(By.xpath("//a[@href=\"/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles\"]"));
		mobiles.click();
			
		driver.navigate().back();
		
		WebElement signIn = driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]"));
		signIn.click();
		
		driver.navigate().back();
		
		WebElement hamburgerMenu = driver.findElement(By.xpath("//a[@id = \"nav-hamburger-menu\"]/i[1]"));
		hamburgerMenu.click();
		
		WebElement bestSellers = driver.findElement(By.xpath("//div[@id=\"hmenu-content\"]//ul/li[2]/a"));
		bestSellers.click();
		Thread.sleep(3000);
		
		WebElement music = driver.findElement(By.xpath("//a[@href=\"/gp/bestsellers/music/ref=zg_bs_nav_music_0\"]"));
		music.click();
//	    WebElement coupons = driver.findElement(By.xpath("//a[contains(@href, '/coupons')]"));
//		coupons.click();
//		Thread.sleep(3000);
//		
//		WebElement selectDepartment = driver.findElement(By.xpath("//div[@data-csa-c-element-id='filter-departments-Amazon Devices & Accessories']//i[@class='a-icon a-icon-radio']"));
//	    selectDepartment.click();
//		
//	    WebElement cart = driver.findElement(By.xpath("//a[@id='nav-cart']"));
//	    cart.click();
//	    Thread.sleep(3000);
//	     
//	    WebElement signIn = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
//	    signIn.click();
//	    Thread.sleep(3000);
//	    
//	     WebElement hamburgerMenu = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
//	     hamburgerMenu.click();
//	     Thread.sleep(3000);

	}
	
	@After
	public void tearDown() {
		//driver.close();
	}

}
