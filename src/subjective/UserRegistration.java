package subjective;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

public class UserRegistration {

	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		   browserLaunch();
			
			positiveFlow();
			
			browserLaunch();
			
			negativeFlow();
			
	}
	
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");			
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void positiveFlow() throws IOException {			
			
		WebElement firstname=driver.findElement(By.name("firstName"));
		
		firstname.sendKeys("SeleniumTestUser");
		
		WebElement lastname=driver.findElement(By.name("lastName"));
				
		lastname.sendKeys("Terrain");
		
		WebElement phone=driver.findElement(By.name("phone"));
				
		phone.sendKeys("3456789325");
		
		WebElement email=driver.findElement(By.name("userName"));
		
		email.sendKeys("demo@gmail.com");
		
		WebElement address=driver.findElement(By.name("address1"));
		
		address.sendKeys("saravana stores");
		
		WebElement city=driver.findElement(By.name("city"));
		
		city.sendKeys("chennai");
		
		WebElement state=driver.findElement(By.name("state"));
		
		state.sendKeys("tamilnadu");
		
		WebElement postalcode=driver.findElement(By.name("postalCode"));
		
		postalcode.sendKeys("600001");
		
		 Select country=new Select(driver.findElement(By.name("country")));
		   
		country.selectByValue("AUSTRALIA");
		
       WebElement userName=driver.findElement(By.name("email"));
		
       userName.sendKeys("TestUser1");		

       WebElement password=driver.findElement(By.name("password"));
		
       password.sendKeys("test@01");
		
       WebElement confirmPassword=driver.findElement(By.name("confirmPassword"));
		
       confirmPassword.sendKeys("test@01");       
       
       System.out.println("****Registration Details****");
       System.out.println();
       
       System.out.println("FirstName : "+firstname.getAttribute("value"));
   
       System.out.println("LastName : "+lastname.getAttribute("value"));
       
       System.out.println("PhoneNumber : "+phone.getAttribute("value"));

       System.out.println("Email ID : "+email.getAttribute("value"));

       System.out.println("Address : "+address.getAttribute("value"));

       System.out.println("City : "+city.getAttribute("value"));

       System.out.println("State : "+state.getAttribute("value"));

       System.out.println("PostalCode : "+postalcode.getAttribute("value"));

       System.out.println("UserName : "+userName.getAttribute("value"));

       System.out.println("Password : "+ password.getAttribute("value"));
       
       System.out.println("ConfirmPassword : "+confirmPassword.getAttribute("value"));
       
       driver.findElement(By.name("submit")).click();
		
       TakesScreenshot scr= ((TakesScreenshot)driver);
	    
	    File source= scr.getScreenshotAs(OutputType.FILE);
	    
	    File desc= new File("src/screenshots/RegisterSuccess.jpg");
	    
	    FileUtils.copyFile(source,desc);
       
      WebElement successMessage= driver.findElement(By.xpath("(//font[@face='Arial, Helvetica, sans-serif'])[3]"));
      
      String Text=successMessage.getText();
      
      System.out.println("The Success Message is displayed : "+Text);
		
      String actual=driver.getTitle();
      
      String Expected="Register: Mercury Tours";      

	  assertEquals(Expected, actual);
	  
	  driver.close();
	}
	
	public static void negativeFlow() throws IOException, InterruptedException {
		
        driver.findElement(By.name("firstName")).sendKeys("User@01");
	 	
	    driver.findElement(By.name("lastName")).sendKeys("Activity");
		
		driver.findElement(By.name("phone")).sendKeys("3456789325");
		
	    driver.findElement(By.name("userName")).sendKeys("guru@gmail.com");
		
		driver.findElement(By.name("address1")).sendKeys("murugan kovil st");
		
		driver.findElement(By.name("city")).sendKeys("chennai");
		
		driver.findElement(By.name("state")).sendKeys("tamilnadu");
		
		driver.findElement(By.name("postalCode")).sendKeys("600111");
		
		Select country=new Select(driver.findElement(By.name("country")));
		   
		country.selectByValue("AUSTRALIA");
		
       driver.findElement(By.name("email")).sendKeys("User1");		

       driver.findElement(By.name("password")).sendKeys("testuser@01");

       driver.findElement(By.name("confirmPassword")).sendKeys("test");  
       
       driver.findElement(By.name("submit")).click();	
       
       Thread.sleep(2000);
       
       JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollTo(0,document.body.scrollHeight)");		 
       
	  WebElement error=driver.findElement(By.xpath("//span[text()='PAssword and con.password does not match']"));
      String errormsg=error.getText();
      assertEquals("PAssword and con.password does not match", errormsg);
      
      TakesScreenshot scr= ((TakesScreenshot)driver);
	    
	    File source= scr.getScreenshotAs(OutputType.FILE);
	    
	    File desc= new File("src/screenshots/RegisterFailure.jpg");
	    
	    FileUtils.copyFile(source,desc);
      
      driver.close();
      
	}

}
