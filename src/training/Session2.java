package training;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Session2 extends ReadDataFromExcel{

	static final Logger logger = LogManager.getLogger(Session2.class.getName());
	
	public static void main(String[] args) throws IOException {		
		
		 DOMConfigurator.configure("log4j.xml");
		 
		 System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();		
		
		driver.get("https://www.sc.com/in/");			
		logger.info("Chrome is lauched");
		
		driver.manage().window().maximize();	
		logger.info("Chrome window is maximized");

/*		code for facebook sign up 
  
 
        driver.findElement(By.id("u_0_m")).sendKeys("testuser1");
		
		driver.findElement(By.name("lastname")).sendKeys("Surname01");
		
	    driver.findElement(By.name("reg_email__")).sendKeys("1234567");	
	    
	    driver.findElement(By.id("u_0_w")).sendKeys("anjshdu47547@");
	    
	   Select day=new Select(driver.findElement(By.id("day")));
	   
	   day.selectByIndex(3);
	   
	   Select month=new Select( driver.findElement(By.id("month")));
	   
	   month.selectByValue("10");
	   
	   Select year=new Select( driver.findElement(By.id("year")));
	   
	   year.selectByVisibleText("2018");
	   
	   
	  WebElement radio= driver.findElement(By.id("u_0_7"));
	  
	  radio.click();*/
	    
//code for SCB login
		
	driver.findElement(By.xpath("//*[@title='Login']")).click();
		
	Actions act=new Actions(driver);
	
	act.moveToElement(driver.findElement(By.xpath("//*[@title='Straight2Bank Login']"))).click().build().perform();
	
	/*String refer="https://s2b.standardchartered.com/ssoapp/login.jsp";
		
	List<WebElement> anchors = driver.findElements(By.tagName("a"));	
    Iterator<WebElement> iter = anchors.iterator();    
    
     while(iter.hasNext()) {
    	 
           WebElement anchor = iter.next();
        
        if(anchor.getAttribute("href").contains(refer)) {
        	
            anchor.click();
            break;
        }
     }
	*/
		System.out.println(driver.findElement(By.id("checkbox-1")).isSelected());
		
		System.out.println(driver.findElement(By.className("button-content")).isEnabled());
		
		String value=ReadDataFromExcel.ReadData(1, 1);
		
		driver.findElement(By.id("userid_email-name")).sendKeys(value);
		
		act.moveToElement(driver.findElement(By.id("checkbox-1"))).click().build().perform();
		logger.info("checkbox is selected");
		
		System.out.println(driver.findElement(By.id("checkbox-1")).isSelected());
		
		System.out.println(driver.findElement(By.className("button-content")).isEnabled());
		
//Taking screenshot code
		
		TakesScreenshot scr= ((TakesScreenshot)driver);
	    
	    File source= scr.getScreenshotAs(OutputType.FILE);
	    
	    File desc= new File("src/screenshots/image.png");
	    
	    FileUtils.copyFile(source,desc);
	    logger.info("Screenshots are taken");

	}

	public Session2() {
		super();
		// TODO Auto-generated constructor stub
	}

}
