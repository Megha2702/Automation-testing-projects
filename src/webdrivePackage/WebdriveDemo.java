package webdrivePackage;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriveDemo {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("The title is: "+title);
		String titleExpected = "Google";
		if(title.equalsIgnoreCase(titleExpected)) {
			System.out.println("Same title, case passed!");
		}
		else {
			System.out.println("Not the same title,Case failed!");
		}
		//driver.quit();
	}

}
