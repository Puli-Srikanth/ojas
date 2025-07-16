package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.CreateLeadsPage;
import ObjectRepository.HomePage;
import ObjectRepository.LeadsInfoPage;
import ObjectRepository.LeadsPage;
import ObjectRepository.LoginPage;

public class TC_08_LeadswithPhoneNumber_POM {

public static void main(String[] args) throws Throwable {
		
	FileUtility futil = new FileUtility();
	ExcelUtility eutil = new ExcelUtility();
	JavaUtility jutil = new JavaUtility();
	
	String browser = futil.getDataFromPropertyFile("browser");
	String url = futil.getDataFromPropertyFile("URL");
	String username = futil.getDataFromPropertyFile("username");
	String password = futil.getDataFromPropertyFile("password");
	
	String leadname = eutil.getDataFromExcelfile("sheet3", 4, 2)+ jutil.getRandomNumber() ;
	String company = eutil.getDataFromExcelfile("sheet3", 4, 4).toString();
	String phone = eutil.getDataFromExcelfile("sheet3", 4, 3).toString();
	
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
	hp.getLeads().click();
	
	LeadsPage lead = new LeadsPage(driver);
	lead.getCreateLeads().click();
	
	CreateLeadsPage clp = new CreateLeadsPage(driver);
	clp.getLeadname().sendKeys(leadname);
	clp.getCompany().sendKeys(company);
	clp.getPhone().sendKeys(phone);
	clp.getSaveLeads().click();
	
	LeadsInfoPage lip = new LeadsInfoPage(driver);
	String name = lip.getLeadInfo().getText();
	String mobileno = lip.getPhoneinfo().getText();
	
	if(name.contains(leadname)) {
		System.out.println(leadname + "-----Passed");
	} else {
		System.out.println(leadname + "-----Failed");
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
