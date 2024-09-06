package junitPackage;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListTag {

	ChromeDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}
	@Test
	public void test() {
		List<WebElement>li = driver.findElements(By.tagName("a"));
		System.out.println("list number:"+li.size());
	}
}
