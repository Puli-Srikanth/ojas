package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CreateProjectandVerifyDatainDBwithGUI {

public static void main(String[] args) throws Throwable {
		
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false);

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		
		//Create Project in GUI using Selenium Code
		Object ProjectName = null;
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://49.249.28.218:8091/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys("sanjay sahu");
		driver.findElement(By.name("createdBy")).sendKeys("bhagi");
		
		WebElement a = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s = new Select(a);
		s.selectByValue("Created");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Verify the project in BackEnd [DB] using JDBC
		boolean flag = false;
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		 Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		 System.out.println("Done");
		 
		Statement stat = conn.createStatement();
		
		ResultSet resultset = stat.executeQuery("select * from TekPyramid");
		while(resultset.next()) {
			String actProjectName = resultset.getString(4);
			if(ProjectName.equals(actProjectName)) {
				flag = true;
				System.out.println(ProjectName + " is available DB==PASS");
			}
		}
		if(flag==false) {
			System.out.println(ProjectName + " is not available DB==FAIL");

		conn.close();
	}
}
}
