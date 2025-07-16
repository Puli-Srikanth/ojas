package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationPage;

public class DeleteOrgTest {

public static void main(String[] args) throws Throwable {
 		
		FileUtility futil = new FileUtility();
		ExcelUtility eutil = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		String browser = futil.getDataFromPropertyFile("browser");
		String url = futil.getDataFromPropertyFile("URL");
		String username = futil.getDataFromPropertyFile("username");
		String password = futil.getDataFromPropertyFile("password");
		
		String orgname = eutil.getDataFromExcelfile("Sheet1", 1, 2) + jutil.getRandomNumber();
		
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
		cop.getSaveOrganization().click();
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String accountname = oip.getOrganizationInfo().getText();
		
		if(accountname.contains(orgname)) {
			System.out.println(orgname + "-----Passed");
		} else {
			System.out.println(orgname + "-----Failed");
		}
		
		//go back to Org page
		hp.getOrg().click();
		
		//search for org
		op.getSearchorg().sendKeys(orgname);
		wutil.toHandleDropdown(op.getSelectorg(), "accountname");
		op.getSearchbtn().click();
		
		//in dynamic web table select and delete org
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		Thread.sleep(3000);
		wutil.toSwitchToAlertAndAccept(driver);
		
		hp.getHomeIcon().click();
		hp.logout();
		driver.quit();
		
}
}
