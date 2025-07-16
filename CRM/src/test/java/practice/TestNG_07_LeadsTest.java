package practice;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.CreateLeadsPage;
import ObjectRepository.HomePage;
import ObjectRepository.LeadsInfoPage;
import ObjectRepository.LeadsPage;

public class TestNG_07_LeadsTest extends BaseClass{

	@Test
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
}
