package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationPage;

public class TC_04_ContactTest_POM {

		public static void main(String[] args) throws Throwable {
			
			FileUtility futil = new FileUtility();
			ExcelUtility eutil = new ExcelUtility();
			
			String browser = futil.getDataFromPropertyFile("browser");
			String url = futil.getDataFromPropertyFile("URL");
			String username = futil.getDataFromPropertyFile("username");
			String password = futil.getDataFromPropertyFile("password");
			
			String contactname = eutil.getDataFromExcelfile("sheet2", 1, 2);
			
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
			ccp.getSaveContact().click();
			
			ContactInfoPage cip = new ContactInfoPage(driver);
			String lastname = cip.getContactInfo().getText();
			
			if(lastname.contains(contactname)) {
				System.out.println(contactname + "-----Passed");
			} else {
				System.out.println(contactname + "-----Failed");
			}
				
			hp.getHomeIcon().click();
			hp.logout();
			driver.quit();
	}
}
