package junitPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJunitPgm {
	ChromeDriver driver;
	@Before
	public void start() {
		driver = new ChromeDriver();
		driver.get("https://yahoo.com");
		
			}
	@Test
	public void test() {
		String title = driver.getTitle();
		System.out.println(title);
		String pageSource = driver.getPageSource();
		if(pageSource.contains("yahoo!")) {
			System.out.println("Content found in the page source");
		}
		else {
			System.out.println("Content not found in the page source");
		}
	}
	@After
	public void afterTest() {
		driver.quit();
	}

}
