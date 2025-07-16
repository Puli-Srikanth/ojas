package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductInfoPage;
import ObjectRepository.ProductPage;

public class TC_09_ProductTest_POM {

public static void main(String[] args) throws Throwable {
		
	FileUtility futil = new FileUtility();
	ExcelUtility eutil = new ExcelUtility();
	
	String browser = futil.getDataFromPropertyFile("browser");
	String url = futil.getDataFromPropertyFile("URL");
	String username = futil.getDataFromPropertyFile("username");
	String password = futil.getDataFromPropertyFile("password");
	
	String productname = eutil.getDataFromExcelfile("sheet4", 1, 2);
	
	WebDriver driver = null;
	if(browser.equals("chrome")) {
		driver = new ChromeDriver();
	}
	else if (browser.equals("edge")) {
		driver = new EdgeDriver();
	}
	else {
		driver = new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
	
	LoginPage lp = new LoginPage(driver);
	lp.login(username, password);
	
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
	hp.logout();
	driver.quit();
	
}
}
