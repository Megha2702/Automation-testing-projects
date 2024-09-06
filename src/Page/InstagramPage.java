package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstagramPage {
WebDriver driver;
	
	By instausername = By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input");
	By instapassword = By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input");
	By instalogin = By.xpath("//div[contains(text(),'Log in')]");
	public InstagramPage(WebDriver driver) {
		this.driver = driver;
	}
	
		
	public void input(String username, String password) {
		driver.findElement(instausername).sendKeys(username);
		driver.findElement(instapassword).sendKeys(password);
	}
	
	public void login() {
		driver.findElement(instalogin).click();
		System.out.println("The login button has been clicked!");		
	}


	}
