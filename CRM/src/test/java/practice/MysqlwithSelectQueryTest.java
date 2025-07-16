package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MysqlwithSelectQueryTest {
public static void main(String[] args) throws Throwable {
	
	Connection conn=null;
	
	try {
	//Step 1 : load/register the database driver
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	
	//Step 2 : connect to database
	conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/TekPyramid", "root", "root");
	 System.out.println("Done");
	 
	 //Step 3 : create Sql statement
	Statement stat = conn.createStatement();
	
	//Step 4 : execute select query & get result
	ResultSet resultset = stat.executeQuery("select * from tp22");
	while(resultset.next()) {
		System.out.println(resultset.getString(1) + "\t" + resultset.getString(2) + "\t" + resultset.getString(3)/* + "\t" + 
						   resultset.getString(4) + "\t" + resultset.getString(5) + "\t" + resultset.getString(6)*/);
	}
	
	} catch (Exception e) {
		System.out.println("handle exeception");
	} finally {
		//Step 5 : close the connection
		conn.close();
		System.out.println("Close the Connection");
	}
	
}
}
