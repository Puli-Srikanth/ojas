package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;

public class RetryAnalyzer_SampleTest extends BaseClass{

	//@Test(retryAnalyzer = GenericUtility.RetryListenerImp.class)
	@Test
	public void createInvoiceTest() {
		System.out.println("execute InvoiceTest");
		String title = driver.getTitle();
		Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	@Test
	public void createInvoicewithContactTest() {
		System.out.println("execute InvoicewithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	} 
}
