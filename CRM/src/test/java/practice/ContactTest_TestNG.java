package practice;

import org.testng.annotations.Test;

public class ContactTest_TestNG {

	@Test
	public void createContact() {
		System.out.println("execute create contact with HDFC");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void modifyContact() {
		System.out.println("execute modify contact HDFC->ICICI");
	}
	
	@Test(dependsOnMethods = "modifyContact")
	public void deleteContact() {
		System.out.println("execute delete contact ICICI");
	}
}
