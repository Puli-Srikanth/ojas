package practice;

import org.testng.annotations.Test;

public class ReadingDataFromCmdLine {
	@Test
	public void readData() {
		System.out.println("My name is "+System.getProperty("name"));
	}
}
