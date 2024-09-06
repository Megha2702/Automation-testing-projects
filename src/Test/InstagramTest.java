package Test;

import org.testng.annotations.Test;

import Page.InstagramPage;

public class InstagramTest extends Baseclass{
	
	@Test
	public void testInstapage() throws InterruptedException {
		InstagramPage page = new InstagramPage(driver); 
		page.input("hello@gmail.com", "attention12test");
		Thread.sleep(3000);
		page.login();
		
		
	}

}
