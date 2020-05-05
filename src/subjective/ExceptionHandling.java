package subjective;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		   System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");			
			
			WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("https://www.google.com/");
		
		try {
			driver.findElement(By.id("submit")).click();			
			} catch (NoSuchElementException e) {
				System.out.println("***No Such Element Exception***");
			}
		
		
			try {
			driver.switchTo().window("new_window");
			} catch (NoSuchWindowException e) {
			System.out.println("***No Such Window Exception***");
			}
			
		
		try {
			driver.switchTo().frame("frame_110");
			} catch (NoSuchFrameException e) {
				System.out.println("***No Such Frame Exception***");
			}
		
		try {
			driver.switchTo().alert().accept();
			} catch (NoAlertPresentException e) {
				System.out.println("***No Alert Present Exception***");
			}
		
		driver.close();
		
			}

}
