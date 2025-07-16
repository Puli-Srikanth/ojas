package practice;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_SoftAssert {

	@Test
	public void homepage(Method mtd) {
		
			System.out.println(mtd.getName()  + "test start");
			SoftAssert asser = new SoftAssert();
			System.out.println("Step-1");
			System.out.println("Step-2");
			asser.assertEquals("Home", "Home-Page");
			System.out.println("Step-3");
			asser.assertEquals("title", "title");
			System.out.println("Step-4");
			asser.assertAll();
			System.out.println(mtd.getName()  + "test end");
	}
	
	@Test
	public void verifylogo(Method mtd) {
		
			System.out.println(mtd.getName() + "test start");
			SoftAssert asser = new SoftAssert();
			System.out.println("Step-1");
			System.out.println("Step-2");
			asser.assertTrue(true);
			System.out.println("Step-3");
			System.out.println("Step-4");
			asser.assertAll();
			System.out.println(mtd.getName() + "test end");
	}
}

