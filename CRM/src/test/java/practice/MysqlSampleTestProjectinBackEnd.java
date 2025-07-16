package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class MysqlSampleTestProjectinBackEnd {

	@Test
	public void projectcheckTest() throws SQLException {
		
		String expectedProjectName = "50";
		boolean flag = false;
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		 Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/TekPyramid", "root", "root");
		 System.out.println("Done");
		 
		Statement stat = conn.createStatement();
		
		ResultSet resultset = stat.executeQuery("select * from tp22");
		while(resultset.next()) {
			String actProjectName = resultset.getString(3);
			if(expectedProjectName.equals(actProjectName)) {
				flag = true;
				System.out.println(expectedProjectName + " is available==PASS");
			}
		}
		if(flag==false) {
			System.out.println(expectedProjectName + " is not available==FAIL");
			//Assert.fail();
		conn.close();
	}
}
}
