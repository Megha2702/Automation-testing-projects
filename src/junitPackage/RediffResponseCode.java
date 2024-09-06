package junitPackage;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffResponseCode {
	ChromeDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}
	
	@Test
	public void testRediff() {
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("The number of the links on the page is: " +li.size());
		for (WebElement webElement : li) {
			String text = webElement.getText();
			String link = webElement.getAttribute("href");
			System.out.println("link text is: "+text+ " . And the link is:"+link);
			verify(link);
		}
	}

	private void verify(String link) {
		// This method is used for finding the response code of the above URL
		try {
			URI ob = new URI(link);
			HttpURLConnection connection = (HttpURLConnection)ob.toURL().openConnection();
			connection.connect();
			System.out.println(connection.getResponseCode());//to print the response code.
			if(connection.getResponseCode() == 200) {
				System.out.println("Successful page "+link);
				
			}
			else if(connection.getResponseCode() == 404) {
				System.out.println("page is not successful and it seems to be a broken link "+link);
				
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
			
		}
		
	}
	

}
