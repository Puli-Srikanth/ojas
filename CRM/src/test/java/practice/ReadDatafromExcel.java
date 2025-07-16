package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatafromExcel {
public static void main(String[] args) throws Throwable{
	
	FileInputStream fis = new FileInputStream("C:\\Users\\SRIKANTH\\OneDrive\\Documents\\Excel_data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	Row row = sh.getRow(1);
	String data = row.getCell(2).getStringCellValue();
	
	System.out.println(data);
	wb.close();
	}
}
