package Test;

import org.testng.annotations.Test;
import Page.FbloginPage;

public class FbloginTest extends Baseclass{

	@Test
	public void testLogin() throws InterruptedException {
		FbloginPage pageOb = new FbloginPage(driver);
		pageOb.setValues("abcd1233", "meghamohan@gmail.com");
		pageOb.clickLogin();
		Thread.sleep(3000);
	}
}
