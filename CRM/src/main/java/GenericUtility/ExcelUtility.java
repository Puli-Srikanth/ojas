package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcelfile(String sheetname, int rowNum, int cellNum) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Excel_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rowNum).getCell(cellNum).toString();
		
		return data;
	}
	
	public int getRowcount(String sheetname) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Excel_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetname).getLastRowNum();
		return rowCount;
	}
	
	public void setDataintoExcdel(String sheetname, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Excel_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Excel_Data.xlsx");
		wb.write(fos);
		wb.close();
	}
}
