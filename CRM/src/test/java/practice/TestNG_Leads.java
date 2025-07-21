package practice;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.CreateLeadsPage;
import ObjectRepository.HomePage;
import ObjectRepository.LeadsInfoPage;
import ObjectRepository.LeadsPage;

public class TestNG_Leads extends BaseClass{

	@Test(groups = "smoke")
	public void createLeadsTest() throws Throwable {
		
		String leadname = eutil.getDataFromExcelfile("sheet3", 1, 2)+ jutil.getRandomNumber() ;
		String company = eutil.getDataFromExcelfile("sheet3", 1, 3);
		
		HomePage hp = new HomePage(driver);
		hp.getLeads().click();
		
		LeadsPage lead = new LeadsPage(driver);
		lead.getCreateLeads().click();
		
		CreateLeadsPage clp = new CreateLeadsPage(driver);
		clp.getLeadname().sendKeys(leadname);
		clp.getCompany().sendKeys(company);
		clp.getSaveLeads().click();
		
		LeadsInfoPage lip = new LeadsInfoPage(driver);
		String name = lip.getLeadInfo().getText();
		
		if(name.contains(leadname)) {
			System.out.println(leadname + "-----Passed");
		} else {
			System.out.println(leadname + "-----Failed");
		}
		
		hp.getHomeIcon().click();
	}
	
	@Test(groups = "regression")
	public void createLeadswithPhoneNumber() throws Throwable {
		
		String leadname = eutil.getDataFromExcelfile("sheet3", 4, 2)+ jutil.getRandomNumber() ;
		String company = eutil.getDataFromExcelfile("sheet3", 4, 4).toString();
		String phone = eutil.getDataFromExcelfile("sheet3", 4, 3).toString();
		
		HomePage hp = new HomePage(driver);
		hp.getLeads().click();
		
		LeadsPage lead = new LeadsPage(driver);
		lead.getCreateLeads().click();
		
		CreateLeadsPage clp = new CreateLeadsPage(driver);
		clp.getLeadname().sendKeys(leadname);
		clp.getCompany().sendKeys(company);
		clp.getPhone().sendKeys(phone);
		clp.getSaveLeads().click();
		
		LeadsInfoPage lip = new LeadsInfoPage(driver);
		String name = lip.getLeadInfo().getText();
		String mobileno = lip.getPhoneinfo().getText();
		
		if(name.contains(leadname)) {
			System.out.println(leadname + "-----Passed");
		} else {
			System.out.println(leadname + "-----Failed");
		}
		
		if(mobileno.contains(phone)) {
			System.out.println(phone + "----Passed");
		} else {
			System.out.println(phone + "----Failed");
		}
		
		hp.getHomeIcon().click();
	}
}
