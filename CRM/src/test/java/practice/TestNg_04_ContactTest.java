package practice;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;

public class TestNg_04_ContactTest extends BaseClass{

	@Test
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
	
}
