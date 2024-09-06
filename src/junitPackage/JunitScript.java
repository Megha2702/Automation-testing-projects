package junitPackage;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitScript {
ChromeDriver driver;

@Before
public void setup() {
	driver = new ChromeDriver();
	driver.get("https://www.google.com");
}

@Test
public void test1() {
	String title = driver.getTitle();
	System.out.println("The title is: "+title);
	String titleExpected = "Google";
	if(title.equalsIgnoreCase(titleExpected)) {
		System.out.println("Same title, case passed!");
	}
	else {
		System.out.println("Not the same title,Case failed!");
	}
}
@After
public void tearDown() {
	driver.quit();
}
	
}







