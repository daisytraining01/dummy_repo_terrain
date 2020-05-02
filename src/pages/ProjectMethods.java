package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Home;
import pages.Login;

public class ProjectMethods {	
	
	 static final Logger logger = LogManager.getLogger(ProjectMethods.class.getName());	

	public static void main(String[] args) throws InterruptedException {

		DOMConfigurator.configure("log4j.xml");

		System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.bigbasket.com/");
		
		logger.info("**************************");
		logger.info("BigBasket website has been launched");		
		
		driver.manage().window().maximize();

		Login lg = new Login(driver);
		lg.enterSearchInput();
		lg.clickSearchIcon();

		Home hm = new Home(driver);
		hm.selectDropDown();
		hm.selectCheckBox();
	}
	}


