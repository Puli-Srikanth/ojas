package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationPage;

public class TC_03_OrgwithPhoneNumber_POM {

public static void main(String[] args) throws Throwable {
		
	FileUtility futil = new FileUtility();
	ExcelUtility eutil = new ExcelUtility();
	JavaUtility jutil = new JavaUtility();
	
	String browser = futil.getDataFromPropertyFile("browser");
	String url = futil.getDataFromPropertyFile("URL");
	String username = futil.getDataFromPropertyFile("username");
	String password = futil.getDataFromPropertyFile("password");
	
	String orgname = eutil.getDataFromExcelfile("sheet1", 7, 2) + jutil.getRandomNumber();
	String phone = eutil.getDataFromExcelfile("sheet1", 7, 3).toString();
	
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
	hp.getOrg().click();
	
	OrganizationPage op = new OrganizationPage(driver);
	op.getCreateOrganization().click();
	
	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	cop.getAccountname().sendKeys(orgname);
	cop.getPhoneno().sendKeys(phone);
	cop.getSaveOrganization().click();
	
	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	String accountname = oip.getOrganizationInfo().getText();
	String mobileno = oip.getPhoneinfo().getText();
	
	if(accountname.contains(orgname)) {
		System.out.println(orgname + "-----Passed");
	} else {
		System.out.println(orgname + "-----Failed");
	}
	
	if(mobileno.contains(phone)) {
		System.out.println(phone + "----Passed");
	} else {
		System.out.println(phone + "----Failed");
	}
		
	hp.getHomeIcon().click();
	hp.logout();
	driver.quit();
	}
}
