package training;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class Session1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();		
		
		driver.get("https://www.sc.com/in/");	
		
		driver.manage().window().maximize();		
					
/*		driver.findElement(By.id("email")).sendKeys("123234223");
		
		driver.findElement(By.name("pass")).sendKeys("abcdce");
		
		driver.findElement(By.tagName("input")).click();
		
		driver.findElement(By.id("loginbutton")).submit();
		
		Select day=new Select(driver.findElement(By.id("day")));
		
		System.out.println(day.isMultiple());
		
		day.selectByIndex(2);
		
        Select month=new Select(driver.findElement(By.id("month")));
		
		month.selectByVisibleText("Jul");
		
		Select year=new Select(driver.findElement(By.id("year")));
			
		year.selectByValue("2018");
		
	    WebElement radio=driver.findElement(By.id("u_0_8"));
	    radio.click();
		
		Select pronoun=new Select(driver.findElement(By.name("preferred_pronoun")));
		
		pronoun.selectByIndex(3);*/
		
	/*	driver.findElement(By.id("loginbutton")).submit();
		Thread.sleep(2000);
		
    	String href="https://www.facebook.com/recover/initiate/?ars=facebook_login";
		List<WebElement> anchors = driver.findElements(By.tagName("a"));
	    Iterator<WebElement> i = anchors.iterator();

	    while(i.hasNext()) {
	        WebElement anchor = i.next();
	        
	        if(anchor.getAttribute("href").contains(href)) {
	            anchor.click();
//	            break;
	        }
		
	    }	*/
	    
	  /*  TakesScreenshot scr= ((TakesScreenshot)driver);
	    
	    File source= scr.getScreenshotAs(OutputType.FILE);
	    
	    File desc= new File("src/screenshots/image.png");
	    
	    FileUtils.copyFile(source,desc);*/
	   
	    
		driver.findElement(By.className("sc-hdr__btn sc-hdr__login-btn")).click();
		
		driver.findElement(By.className("sc-minimgnv__link bank-login")).click();
		
		driver.findElement(By.id("userid_email-name")).sendKeys("sdgfsgdf");
		
		driver.findElement(By.id("group_id-name")).sendKeys("sdgfsgdf");
		
		driver.findElement(By.id("-name")).click();
		
		driver.findElement(By.id("unified_password-name")).sendKeys("ASDSFSDF");
		
		driver.findElement(By.linkText("LOGIN")).click();	
		
		
        Alert alert=driver.switchTo().alert();
	    
	    String alerttext=alert.getText();
	    
	    System.out.println(alerttext);
	    
	    alert.accept();
	    
	 /*WebElement checkbox1=  driver.findElement(By.id("dateSpecific"));
	 
	 checkbox1.click();
	 
     WebElement checkbox2=  driver.findElement(By.id("concessionBooking"));
	 
	 checkbox2.click();
	 
	 driver.findElement(By.linkText("Find trains")).submit();
	 
	    
	  driver.findElement(By.linkText("Ok")).click();
		 
 	driver.close();
	*/	

}
}