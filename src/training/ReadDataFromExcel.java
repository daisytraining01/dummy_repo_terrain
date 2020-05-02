package training;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	
	public static String ReadData(int rownum,int columnnum) throws IOException {
		
		String filename="src/Data/Sample.xlsx";	
		
		FileInputStream fio=new FileInputStream(filename);
		
		
		XSSFWorkbook workbook=new XSSFWorkbook(fio);//open the workbook
		
		XSSFSheet sheet=workbook.getSheetAt(0);//get the sheet at index 0
		
		Row row=sheet.getRow(rownum);//get the row number
		
		Cell col=row.getCell(columnnum);//get the cell number
		
		String cellvalue=col.getStringCellValue();//store the cell value 
		
		return cellvalue;
		
	}
	
	
}

//Check the cell type and format accordingly
/*switch (cell.getCellType()) 
{
    case Cell.CELL_TYPE_NUMERIC:
        System.out.print(cell.getNumericCellValue() + "t");
        break;
    case Cell.CELL_TYPE_STRING:
        System.out.print(cell.getStringCellValue() + "t");
        break;
}*/