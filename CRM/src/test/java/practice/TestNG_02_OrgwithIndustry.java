package practice;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationPage;

public class TestNG_02_OrgwithIndustry extends BaseClass{

	@Test
	public void createOrgwithIndustry() throws Throwable {
	String orgname = eutil.getDataFromExcelfile("sheet1", 4, 2) + jutil.getRandomNumber();
	String industry = eutil.getDataFromExcelfile("sheet1", 4, 3).toString();
	
	HomePage hp = new HomePage(driver);
	hp.getOrg().click();
	
	OrganizationPage op = new OrganizationPage(driver);
	op.getCreateOrganization().click();
	
	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	cop.getAccountname().sendKeys(orgname);
	cop.getIndustrydropdown().sendKeys(industry);
	cop.getSaveOrganization().click();
	
	Thread.sleep(3000);
	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	String accountname = oip.getOrganizationInfo().getText();
	
	if(accountname.contains(orgname)) {
		System.out.println(orgname + "-----Passed");
	} else {
		System.out.println(orgname + "-----Failed");
	}
	hp.getHomeIcon().click();
	}
}
