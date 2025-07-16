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
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationPage;

public class TC_06_ContactwithOrgTest_POM {

	public static void main(String[] args) throws Throwable {
				
		FileUtility futil = new FileUtility();
		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		
		String browser = futil.getDataFromPropertyFile("browser");
		String url = futil.getDataFromPropertyFile("URL");
		String username = futil.getDataFromPropertyFile("username");
		String password = futil.getDataFromPropertyFile("password");
		
		String lastname = eutil.getDataFromExcelfile("sheet2", 4, 2);
		String orgname = eutil.getDataFromExcelfile("sheet2", 4, 3)+jutil.getRandomNumber();
		
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
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.getAccountname().sendKeys(orgname);
		cop.getSaveOrganization().click();
		Thread.sleep(2000);
		hp.getContact().click(); 
		
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContact().click();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		String parent=driver.getWindowHandle();
		
		ccp.getContactname().sendKeys(lastname);
		ccp.getOrglink().click();
		Thread.sleep(2000);
		//switch to child window
		wutil.toSwitchBetweenWindowThroughIndex(driver, 2);
		
		ccp.getOrgname().sendKeys(orgname);
		ccp.getSearchorg().click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		//driver.findElement(By.xpath("(//a][text()='teddy'])/../../../tr[5]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		
		ccp.getSaveContact().click();
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactname = cip.getContactInfo().getText();
		String org = cip.getOrgname().getText().trim();
		
		System.out.println("*******************************Actual Contact:"+contactname+" Expected Contact:"+lastname+"*******************************");
		if(lastname.contains(contactname)) {
			System.out.println(contactname + "-----Passed");
		} else {
			System.out.println(contactname + "-----Failed");
		}
		
		System.out.println("*******************************Actual Org:"+org+" Expected Org:"+orgname+"*******************************");
		if(orgname.contains(org)) {
			System.out.println(org + "-----Passed");
		} else {
			System.out.println(org + "-----Failed");
		}
		
		hp.getHomeIcon().click();
		hp.logout();
		driver.quit();
	}
}
