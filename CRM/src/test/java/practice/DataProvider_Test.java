package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Test {

	@Test(dataProvider = "getData")
	public void createContactTest(String firstname , String lastname , long phoneNumber) {
		System.out.println("Firstname :"+ firstname + ", Lastname :"+ lastname + ", PhoneNumber :"+ phoneNumber);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] array = new Object[3][3];
		array[0][0] = "jawan";
		array[0][1] = "azad";
		array[0][2] = 9874563210l;
		
		array[1][0] = "jawan";
		array[1][1] = "vikram";
		array[1][2] = 1236547890l;
		
		array[2][0] = "pathaan";
		array[2][1] = "spy";
		array[2][2] = 7412589630l;
				
				return array;
	}
}
