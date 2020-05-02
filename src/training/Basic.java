package training;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		 
		// Open facebook
		driver.get("http://www.facebook.com");
		 
		// Maximize browser		 
		driver.manage().window().maximize();
		
	
		driver.findElement(By.name("email")).sendKeys("1234556577");
        driver.findElement(By.name("pass")).sendKeys("abcdfef");
        
        driver.findElement(By.linkText("Log In")).click();        
        
		driver.close();
	}

	
	
	/*String actualtitle=driver.getTitle();
	System.out.println(actualtitle);
	
	if(actualtitle.equals("Facebook – log in or sign up")) {
		System.out.println("Pass");
	}else {
		System.out.println("fail");
	}	
	
	String pagesource=driver.getPageSource();
//	System.out.println(pagesource);	
	driver.findElement(By.id("loginbutton")).click();
	 Thread.sleep(2000);		
	 String url=driver.getCurrentUrl();
	 System.out.println(url);
	 driver.navigate().back();
	 driver.navigate().forward();
	 driver.navigate().refresh();*/
}
