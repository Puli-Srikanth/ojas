package practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Task_BC_LI.Task_BC;

@Listeners(Task_BC_LI.Task_LI.class)
public class Task_TS extends Task_BC{

	@Test
	public void pardes() {
		System.out.println("execute pardes");
	}
	
	@Test
	public void swades() {
		System.out.println("execute swades");
	}
	
	@Test
	public void Don() {
		System.out.println("execute Don");
	}
}
