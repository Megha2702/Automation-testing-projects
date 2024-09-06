package testNGpackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import java.nio.file.Paths;

public class FileUpload {
	
		WebDriver driver;
		String url = "https://www.ilovepdf.com/word_to_pdf";
		@BeforeTest
		public void setUp() {
			driver = new ChromeDriver();
			driver.get(url);
			
		}
		
		@Test
		public void testFileUpload() throws AWTException, InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
			fileUpload("D:\\Software_testing\\Answers-sql.docx");
            
		}
		
		public void fileUpload(String p) throws AWTException, InterruptedException {
			// Copy the file path to clipboard
			StringSelection strSelection = new StringSelection(p);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
			
			// Use Robot class to handle the file dialog
			Robot robot = new Robot();
			
			robot.delay(2000);
			Thread.sleep(2000);
			
			// Paste the file path using CTRL + V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			
			// Press ENTER to upload the file
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_ENTER);
						
//			if(driver.findElements(By.xpath("//a[contains(text(), 'Download')]")).size() > 0) {
//                System.out.println("File uploaded successfully!");
//            } else {
//                System.out.println("File upload failed or still in progress.");
//            }
			
						
		}
}
