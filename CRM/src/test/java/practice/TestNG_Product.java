package practice;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ProductInfoPage;
import ObjectRepository.ProductPage;

public class TestNG_Product extends BaseClass{
	
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

	@Test
	public void createProductwithCategory() throws Throwable {
		
		String productname = eutil.getDataFromExcelfile("sheet4", 4, 2);
		String category = eutil.getDataFromExcelfile("sheet4", 4, 3);
		
		HomePage hp = new HomePage(driver);
		hp.getProducts().click();
		
		ProductPage pp = new ProductPage(driver);
		pp.getCreateProduct().click();
		
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductname().sendKeys(productname);
		cpp.getCategorydropdown().sendKeys(category);
		cpp.getSaveProducts().click();
		
		ProductInfoPage pip = new ProductInfoPage(driver);
		String lastname = pip.getProductInfo().getText();
		String dropdown = pip.getCategoryInfo().getText();
		
		if(lastname.contains(productname)) {
			System.out.println(productname + "-----Passed");
		} else {
			System.out.println(productname + "-----Failed");
		}
		
		if(dropdown.contains(category)) {
			System.out.println(category + "-----Passed");
		} else {
			System.out.println(category + "-----Failed");
		}
			
		hp.getHomeIcon().click();
	}
}
