package training;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import training.ReadDataFromExcel;

public class Facebook extends ReadDataFromExcel{
	
	static final Logger logger = LogManager.getLogger(Facebook.class.getName());	
	
	public static void main(String[] args) throws IOException {
		
		    DOMConfigurator.configure("log4j.xml");
		
		    System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
			
			WebDriver driver=new ChromeDriver();		
			
			
			driver.get("https://www.facebook.com/");
			logger.info("************************************************");
			logger.info("Chrome is lauched");
			
			driver.manage().window().maximize();	
			
			logger.info("Chrome window is maximized");
			
		driver.findElement(By.id("u_0_m")).sendKeys(ReadData(1, 0));

		logger.info("First name is entered");

		driver.findElement(By.name("lastname")).sendKeys(ReadData(1, 1));

		logger.info("Surname is entered");

		driver.findElement(By.name("reg_email__")).sendKeys(ReadData(1, 2));

		logger.info("phone number is netered");

		driver.findElement(By.id("u_0_w")).sendKeys(ReadData(1, 3));

	    logger.info("password is entered");
	    
	   Select day=new Select(driver.findElement(By.id("day")));
	   
	   day.selectByIndex(3);
	   
	   Select month=new Select( driver.findElement(By.id("month")));
	   
	   month.selectByValue("10");
	   
	   Select year=new Select( driver.findElement(By.id("year")));
	   
	   year.selectByVisibleText("2018");
	   
	   
	  WebElement radio= driver.findElement(By.id("u_0_7"));
	  
	  radio.click();
	}

}
