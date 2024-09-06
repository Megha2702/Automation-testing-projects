package junitPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgGroups {

	@BeforeTest(alwaysRun = true)
	public void setUp() {
		System.out.println("Hello");
	}
	@BeforeMethod(alwaysRun = true)
	public void urlLoding() {
		System.out.println("url loading");
	}
	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println("test1");
	}
	@Test(groups = {"sanity","regression"})
	public void test2() {
		System.out.println("test2");
	}
	@Test
	public void test3() {
		System.out.println("test3");
	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("hello");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
}
