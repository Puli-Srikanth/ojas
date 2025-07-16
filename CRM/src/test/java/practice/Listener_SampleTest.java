package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;

@Listeners(GenericUtility.ListenersImplementation.class)
public class Listener_SampleTest extends BaseClass{

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
