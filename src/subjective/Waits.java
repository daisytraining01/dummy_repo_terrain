package subjective;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Waits {

	public static void main(String[] args) throws AWTException, InterruptedException {
		

		   System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");			
			
			WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("https://www.google.com/");
			
			// Implicit wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			
			driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("gmail");
			
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			// Explicit wait	
			Thread.sleep(2000);
			
			// WebDriver wait
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10); 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='Search']")
					));
		}finally {
			System.out.println("Different Types of Waits has been invoked");
		}		

		// Fluent Wait
	   Wait wait = new FluentWait(driver) 
				.withTimeout(50, TimeUnit.SECONDS)
				.pollingEvery(15, TimeUnit.SECONDS)
				.ignoring(Exception.class);
	   
	   driver.close();
		
	}
}
