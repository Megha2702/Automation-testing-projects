package webdrivePackage;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebdrivePgm {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String source = driver.getPageSource();
		if (source.contains("Gmail")) {
            System.out.println("The specific text is present in the page source.");
        } else {
            System.out.println("The specific text is not present in the page source.");
        }
		driver.quit();
	}

}
