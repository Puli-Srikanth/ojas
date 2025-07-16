package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import GU.ContactInfoPage;
import GU.ContactPage;
import GU.CreateNewContactPage;
import GenericUtility.BaseClass;
import ObjectRepository.HomePage;

public class sample extends BaseClass {

	@Test(groups = "smokeTest")
	public void CreateContactWithSupportDateTest() throws Throwable {

		// read data from excel file
		String contactname = eutil.getDataFromExcelfile("sheet2", 1, 2);

		HomePage op = new HomePage(driver);
		op.getContact().click();

		ContactPage cnp1 = new ContactPage(driver);
		cnp1.getCreateNewContactBtn().click();

		CreateNewContactPage cnop = new CreateNewContactPage(driver);

		String startdate = jutil.getSystemDateYYYYDDMM();
		String enddate = jutil.getRequiredDateYYYYDDMM(30);

		cnop.createContact(contactname, startdate, enddate);

		ContactInfoPage oip = new ContactInfoPage(driver);
		String start = oip.getStartDateType().getText().toString();

		System.out.println(start);
		boolean status = startdate.contains(startdate);
		Assert.assertEquals(status, true);
		System.out.println("assertion pass"); // Hard Assert

//		             if(start.contains(startdate)) {
//		            	 System.out.println(startdate+"---------PASSED");
//		             }else {
//		            	 System.out.println(startdate+"---------FAILED");
//	             }

		String end = oip.getEndDateType().getText().toString();
		boolean status1 = end.contains(enddate);
		Assert.assertEquals(status1, true);
		System.out.println("assertion pass"); // Hard Assert

		if (end.contains(enddate)) {
			System.out.println(enddate + "---------PASSED");
		} else {
			System.out.println(enddate + "---------FAILED");
		}

	}
}
