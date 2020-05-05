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
		
						
			WebElement table=driver.findElement(By.xpath("//*[@id='main']/div[3]/table/tbody/tr[1]/th"));
			
			List<WebElement> rows=table.findElements(By.tagName("tr"));
			 
			for(int rownum=0;rownum<rows.size();rownum++)
			{
			List<WebElement> columns=rows.get(rownum).findElements(By.tagName("th"));
			System.out.println("Number of columns:"+columns.size());
			 
			for(int colnum=0;colnum<columns.size();colnum++)
			{
			System.out.println(columns.get(colnum).getText());
			}
			}
			
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
