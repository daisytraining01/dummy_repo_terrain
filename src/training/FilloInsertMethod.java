package training;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloInsertMethod {
	
	public static void filloInsert() throws FilloException {	
	
	Fillo fillo=new Fillo();
	
	Connection con= fillo.getConnection("src/Data/Fillo.xlsx");
	
	String query="INSERT INTO Sample(Name,Number) VALUES('Peter','100')";
	
	con.executeQuery(query);
	}
	
	public static void main(String[] args) throws FilloException {
		filloInsert();
	
}
}