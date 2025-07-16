package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDatafromExcel {
public static void main(String[] args) throws Throwable {
	
	FileInputStream fis = new FileInputStream("C:\\Users\\SRIKANTH\\OneDrive\\Documents\\Excel_data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet2");
	
	int rowcount = sh.getLastRowNum();
	for(int i=1;i<=rowcount;i++) {
		
	
	Row row = sh.getRow(i);
	
	String col1data = row.getCell(0).toString();
	String col2data = row.getCell(1).toString();
	
	System.out.println(col1data +" "+ col2data);
	}
	
	wb.close();
}
}
