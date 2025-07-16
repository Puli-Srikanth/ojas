package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Config {

	@Test
	public void createconfigTest() {
		System.out.println("execute test 2");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("execute AM");
	}
	
	@BeforeSuite
	public void configBS() {
		System.out.println("execute BS");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("execute AC");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("execute BM");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("execute AS");
	}
	
	@Test
	public void createconfig() {
		System.out.println("execute test");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("execute BC");
	}
	
}
