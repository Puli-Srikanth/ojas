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
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationPage;

public class TC_01_OrgTest_POM {

	public static void main(String[] args) throws Throwable {
 		
		FileUtility futil = new FileUtility();
		ExcelUtility eutil = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		
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
		boolean status = accountname.contains(orgname);
		Assert.assertEquals(status, true);
		/*if(accountname.contains(orgname)) {
			System.out.println(orgname + "-----Passed");
		} else {
			System.out.println(orgname + "-----Failed");
		}*/
		
		hp.getHomeIcon().click();
		hp.logout();
		driver.quit();
	}
}
