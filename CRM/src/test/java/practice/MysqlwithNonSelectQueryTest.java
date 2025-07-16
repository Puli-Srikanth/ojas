package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MysqlwithNonSelectQueryTest {
	public static void main(String[] args) throws Throwable {
		
		//Step 1 : load/register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2 : connect to database
		 Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/TekPyramid", "root", "root");
		 System.out.println("Done");
		 
		 //Step 3 : create Sql statement
		Statement stat = conn.createStatement();
		
		//Step 4 : execute select query & get result
		int res = stat.executeUpdate("insert into TP22 values('king', '67', 'srk67@gmail.com')");
		System.out.println(res);
	}
}
