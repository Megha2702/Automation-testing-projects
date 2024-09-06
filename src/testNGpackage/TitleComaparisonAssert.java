package testNGpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TitleComaparisonAssert {
WebDriver driver;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		String title = driver.getTitle();
		String expTitle = "Facebook";
		Assert.assertEquals(title, expTitle, "The title is not equal as the expected");
		System.out.println("Title is equal.Go ahead!");
	}
}
