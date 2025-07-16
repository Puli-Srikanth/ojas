package practice;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import GenericUtility.ListenersImplementation;
import GenericUtility.UtilityClassObject;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationPage;

public class TestNg_01_OrgTest extends BaseClass{

	@Test(groups = "smoke")
	public void createOrgTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		//ListenersImplementation.test.log(Status.INFO, "read data from excel");
		String orgname = eutil.getDataFromExcelfile("Sheet1", 1, 2) + jutil.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org page");
		//ListenersImplementation.test.log(Status.INFO, "navigate to Org page");
		HomePage hp = new HomePage(driver);
		hp.getOrg().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create to Org page");
		//ListenersImplementation.test.log(Status.INFO, "navigate to create to Org page");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganization().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "craete a new Org");
		//ListenersImplementation.test.log(Status.INFO, "craete a new Org");
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getAccountname().sendKeys(orgname);
		cop.getSaveOrganization().click();
		
		UtilityClassObject.getTest().log(Status.INFO, orgname + "----created a new Org");
		//ListenersImplementation.test.log(Status.INFO, orgname + "----created a new Org");
		
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
