package practice;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ProductInfoPage;
import ObjectRepository.ProductPage;

public class TestNG_09_ProductTest extends BaseClass{

	@Test
	public void createProductTest() throws Throwable {
		
		String productname = eutil.getDataFromExcelfile("sheet4", 1, 2);
		
		HomePage hp = new HomePage(driver);
		hp.getProducts().click();
		
		ProductPage pp = new ProductPage(driver);
		pp.getCreateProduct().click();
		
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductname().sendKeys(productname);
		cpp.getSaveProducts().click();
		
		ProductInfoPage pip = new ProductInfoPage(driver);
		String lastname = pip.getProductInfo().getText();
		
		if(lastname.contains(productname)) {
			System.out.println(productname + "-----Passed");
		} else {
			System.out.println(productname + "-----Failed");
		}
			
		hp.getHomeIcon().click();
		
	}
}
