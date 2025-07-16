package practice;

import org.testng.annotations.Test;

public class OrderTest_TestNG {

	@Test(invocationCount = 10)
	public void createOrderTest() {
		System.out.println("execute createOrderTest->123");
		//String str=null;
		//System.out.println(str.equals("123"));
	}
	@Test(enabled = false)
	public void billingAndOrder() {
		System.out.println("execute billing and order->123");
	}
}
