package junitPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg {

	@BeforeTest
	public void setUp() {
		System.out.println("browser open");
	}
	@BeforeMethod
	public void urlLoding() {
		System.out.println("url loading");
	}
	@Test(priority = 2)
	public void test1() {
		System.out.println("Successful test1");
	}
	@Test(priority = 1, enabled = false)
	public void test2() {
		System.out.println("Successful test2 ");
	}
	@Test(priority = 3, invocationCount = 2, dependsOnMethods = {"test1"})
	public void test3() {
		System.out.println("Successful test3");
	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("Hello, this is testNG execution.");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("Testing completed and quit the browser");
	}
}
