package practice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Sample_ReportTest_ScreenShot {

	public ExtentReports report;
	@BeforeSuite
	public void configBS() {
		//Spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./SampleReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("browser", "chrome");
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
	@Test
	public void createTest() {
	WebDriver driver = new ChromeDriver();
	driver.get("http://49.249.28.218:8888/");
	
	//Take ScreenShot
	TakesScreenshot ts = (TakesScreenshot)driver;
	String filepath = ts.getScreenshotAs(OutputType.BASE64);
	
	ExtentTest test = report.createTest("createTest");
	
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"navigate to account page");
	test.log(Status.INFO,"create account");
	if("AXIS".equals("AXES")) {
		test.log(Status.PASS,"account is created");
	} else {
		test.addScreenCaptureFromBase64String(filepath, "ErrorFile");
		
	}
	driver.close();
}
}
