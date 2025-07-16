package practice;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assertion_HardAssert {

	@Test
	public void homepage(Method mtd) {
		
			Reporter.log(mtd.getName()  + "test start");
			Reporter.log("Step-1",true);
			Reporter.log("Step-2",true);
			//Assert.assertEquals("Home", "Home-Page");
			Reporter.log("Step-3",true);
			//Assert.assertEquals("Home-CRM", "Home-CRM");
			Reporter.log("Step-4",true);
			//System.out.println(mtd.getName()  + "test end");
	}
	
	@Test
	public void verifylogo(Method mtd) {
		
		Reporter.log(mtd.getName() + "test start");
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
			//Assert.assertTrue(true);
			Reporter.log("Step-3",true);
			Reporter.log("Step-4",true);
			//System.out.println(mtd.getName() + "test end");
	}
}
