package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	Connection con;
	public void getDataBaseConnection(String url, String username, String password) throws SQLException {
		try {
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		
		con = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {	
		}
	}
	
	public void getDataBaseConnection() throws SQLException {
		try {
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		
		con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/TekPyramid", "root", "root");
		}catch (Exception e) {	
		}
	}
	
	public void closeDBconnection() throws SQLException {
		try {
			con.close();
		} catch (Exception e) {
			
		}
		con.close();
	}
	
	public ResultSet executeSelectQuery(String query) throws Throwable {
		ResultSet result = null;
		try {
		Statement stat = con.createStatement();
		result = stat.executeQuery(query);
		}catch (Exception e) {
		}
		return result;
	}
	
	public int executeNonSelectQuery(String query ) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result=stat.executeUpdate(query);
			}catch (Exception e) {
			}
		return result;
	}
}
