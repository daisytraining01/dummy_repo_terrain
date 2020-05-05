package subjective;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	
	public static WebDriver driver;
	
		public static void tableData() {
		
			WebElement tablebody=driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/table/tbody"));
			
			tablebody.getSize();
			
			WebElement tableheader=driver.findElement(By.xpath("//*[@id='main']/div[3]/table/tbody/tr[1]/th"));
			
			tableheader.getSize();
			
			WebElement tablerow=driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/table/tbody/tr"));
			
			System.out.println(tablerow.getText());
			
			driver.close();
		}

		public static void main(String[] args) {
			
			System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");			
			
			 driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("https://www.w3schools.com/sql/sql_syntax.asp");
			
			tableData();
	
	}

}
