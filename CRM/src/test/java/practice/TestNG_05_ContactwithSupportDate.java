package practice;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;

public class TestNG_05_ContactwithSupportDate extends BaseClass{

	@Test
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
}
