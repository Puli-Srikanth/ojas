package practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationPage;

public class TestNG_06_ContactwithOrgTest extends BaseClass{

	@Test
	public void createContactwithOrg() throws Throwable {
		
		String lastname = eutil.getDataFromExcelfile("sheet2", 4, 2);
		String orgname = eutil.getDataFromExcelfile("sheet2", 4, 3)+jutil.getRandomNumber();
		
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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		
		ccp.getSaveContact().click();
		
		Thread.sleep(3000);
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
	}
}
