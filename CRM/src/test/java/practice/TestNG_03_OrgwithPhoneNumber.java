package practice;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationPage;

public class TestNG_03_OrgwithPhoneNumber extends BaseClass{

	@Test
	public void createOrgwithPhoneNumber() throws Throwable {
	String orgname = eutil.getDataFromExcelfile("sheet1", 7, 2) + jutil.getRandomNumber();
	String phone = eutil.getDataFromExcelfile("sheet1", 7, 3);
	
	HomePage hp = new HomePage(driver);
	hp.getOrg().click();
	
	OrganizationPage op = new OrganizationPage(driver);
	op.getCreateOrganization().click();
	
	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	cop.getAccountname().sendKeys(orgname);
	cop.getPhoneno().sendKeys(phone);
	cop.getSaveOrganization().click();
	
	Thread.sleep(3000);
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
	}
}
