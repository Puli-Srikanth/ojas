package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBacktoExcel {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("C:\\Users\\SRIKANTH\\OneDrive\\Documents\\Excel_data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet3");
	Row row = sh.getRow(1);
	Cell cell = row.createCell(4);
	cell.setCellValue("PASS");
	
	FileOutputStream fos = new FileOutputStream("C:\\Users\\SRIKANTH\\OneDrive\\Documents\\Excel_data.xlsx");
	wb.write(fos);
	wb.close();
	System.out.println("----Executed----");
}
}
