package pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Home extends ProjectMethods{
	
WebDriver driver;
	
@FindBy(how=How.XPATH, using="//select[@id='sel1']")
WebElement relevanceDropDown;

@FindBy(how=How.XPATH, using="(//*[@class='ng-binding' and text()='bb Popular'])[3]")
WebElement checkBox;


public void selectDropDown() {
	
	
	relevanceDropDown.click();
	
	logger.info("Drop down is clicked");
	
	Select drop=new Select(relevanceDropDown);
	drop.selectByIndex(1);
	
	logger.info("dropdown value is selected");
	
}

public void selectCheckBox() throws InterruptedException {
	
	Thread.sleep(4000);
	
	checkBox.click();
	
	logger.info("checkbox is clicked");
}

	public Home(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
