package training;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloSelectMethod {
	
		public static void FilloSelect() throws FilloException {
			
		Fillo fillo = new Fillo();
		
		Connection connection = fillo.getConnection("src/Data/Fillo.xlsx");	
		
		String strQuery = "Select * from Sample";
		
		Recordset recordset = connection.executeQuery(strQuery);
		
		System.out.println(recordset.getCount());	
		
		while(recordset.next()){
		
			System.out.println(recordset.getField("Name"));
		}
		 
		recordset.close();
		connection.close();
}
		public static void main(String[] args) throws FilloException {
			
			FilloSelect();
}

}
