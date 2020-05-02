package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import training.ReadDataFromExcel;
import training.Session2;

public class Login extends ProjectMethods{
	
	  WebDriver driver;
	  
	@FindBy(how=How.ID, using="input")
	WebElement searchBox;
	
	@FindBy(how=How.XPATH,using="//button[@type='submit']") 
	WebElement searchIcon;
	
	
	public void enterSearchInput() {	
		
		searchBox.sendKeys("fruits");
		logger.info("search input is provided");
			
	}
	
	public void clickSearchIcon() {	
		
		searchIcon.click();
		logger.info("Search icon is clicked");
			}
	
		
public Login(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
		
}
