package practice;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;

public class Config_TC_01 extends BaseClass{

	@Test
	public void createOrg() {
		System.out.println("execute Orgtest and verify");
	}
	
	@Test
	public void createOrgwithIndustry() {
		System.out.println("execute OrgwithIndustry and verify");
	}
	
}
