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

public class TestNG_Contacts extends BaseClass{

	@Test(groups = "smoke")
	public void createContactTest() throws Throwable {

	String contactname = eutil.getDataFromExcelfile("sheet2", 1, 2);
	
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
}
	
	@Test(groups = "regression")
	public void createContactwithSupportDate() throws Throwable {
		
		String contactname = eutil.getDataFromExcelfile("sheet2", 1, 2);
		
		String start = jutil.getSystemDateYYYYDDMM();
		String end = jutil.getRequiredDateYYYYDDMM(30);
		
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
		
		if(lastname.contains(contactname)) {
			System.out.println(contactname + "-----Passed");
		} else {
			System.out.println(contactname + "-----Failed");
		}
		
		if(startdate.equals(start)) {
			System.out.println(start + "----Passed");
		} else {
			System.out.println(start + "----Failed");
		}
		
		System.out.println(enddate);
		
		if(enddate.equals(end)) {
			System.out.println(end + "----Passed");
		} else {
			System.out.println(end + "----Failed");
		}
			
		hp.getHomeIcon().click();
	}
	
	@Test(groups = "regression")
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
