package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtility;

public class DataProvider_GetProductInfo  {

	@Test(dataProvider = "getData")
	public void getProductInfo (String brandName , String ProductName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://amazon.in");
		
		//Search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
		
		//Capture product info
		WebElement product = driver.findElement(By.xpath("//span[text()='"+ProductName+"']/ancestor::div[@class='puisg-col-inner']/descendant::span[@class='a-price']"));
		String price = product.getText();
		System.out.println(price);
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		
		ExcelUtility eutil = new ExcelUtility();
		int rowcount = eutil.getRowcount("sheet5");
		
		
		Object[][] array = new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++) {
		array[i][0] = eutil.getDataFromExcelfile("sheet5", i+1, 0);
		array[i][1] = eutil.getDataFromExcelfile("sheet5", i+1, 1);
		}
				
				return array;
	}
}
