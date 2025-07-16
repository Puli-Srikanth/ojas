package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class TC_05_ContactwithSupportDate_POM {

	public static void main(String[] args) throws Throwable {
		
		FileUtility futil = new FileUtility();
		ExcelUtility eutil = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		
		String browser = futil.getDataFromPropertyFile("browser");
		String url = futil.getDataFromPropertyFile("URL");
		String username = futil.getDataFromPropertyFile("username");
		String password = futil.getDataFromPropertyFile("password");
		
		String contactname = eutil.getDataFromExcelfile("sheet2", 1, 2);
		
		String start = jutil.getSystemDateYYYYDDMM();
		String end = jutil.getRequiredDateYYYYDDMM(30);
		
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
		hp.getContact().click();
		
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContact().click();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getContactname().sendKeys(contactname);
		ccp.getStartDate().clear();
		ccp.getStartDate().sendKeys(start);
		ccp.getEndDate().clear();
		ccp.getEndDate().sendKeys(end);
		ccp.getSaveContact().click();
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String lastname = cip.getContactInfo().getText();
		String startdate = cip.getStartDateInfo().getText();
		String enddate = cip.getEndDateInfo().getText();
		
		boolean status=lastname.contains(contactname);
		Assert.assertTrue(status);
		Assert.assertEquals(lastname, contactname);
		System.out.println(status);
		
//		if(lastname.contains(contactname)) {
//			System.out.println(contactname + "-----Passed");
//		} else {
//			System.out.println(contactname + "-----Failed");
//		}
		boolean status1=startdate.contains(start);
		Assert.assertTrue(status1);
		System.out.println(status1);
//		if(startdate.equals(start)) {
//			System.out.println(start + "----Passed");
//		} else {
//			System.out.println(start + "----Failed");
//		}
		
		System.out.println(enddate);
		
		boolean status2=enddate.contains(end);
		Assert.assertTrue(status2);
		System.out.println(status2);
//		if(enddate.equals(end)) {
//			System.out.println(end + "----Passed");
//		} else {
//			System.out.println(end + "----Failed");
//		}
			
		hp.getHomeIcon().click();
		hp.logout();
		driver.quit();
		
	}
}
