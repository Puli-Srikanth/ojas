package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatabasedonCondition {
	public static void main(String[] args) throws Throwable{
		
		String expectedTestId = "tc_02";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		Boolean flag=false;
		FileInputStream fis = new FileInputStream("C:\\Users\\SRIKANTH\\OneDrive\\Documents\\Excel_data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet3");
		
		int rowcount = sh.getLastRowNum();
		
		for(int i=0; i<=rowcount;i++) {
			String data="";
			try {
				data = sh.getRow(i).getCell(0).toString();
				if(data.equals(expectedTestId)) {
					data1=sh.getRow(i).getCell(1).toString();
					data2=sh.getRow(i).getCell(2).toString();
					data3=sh.getRow(i).getCell(3).toString();
				}
			}catch (Exception e) {
				if(flag==true) {
					System.out.println(data1);
					System.out.println(data2);
					System.out.println(data3);
				}
			}
			System.out.println(expectedTestId + "data is not available");
		}
		
		
		wb.close();
		}
}
