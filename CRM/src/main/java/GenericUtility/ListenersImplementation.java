package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener, ISuiteListener {

	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		
		//Spark report config
				spark = new ExtentSparkReporter("./SampleReport/report.html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM report");
				spark.config().setTheme(Theme.DARK);
				
				//add Env information & create test
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "Windows");
				report.setSystemInfo("browser", "chrome");
	}
	
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("---->"+result.getMethod().getMethodName()+"<--start--");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"---->START<----");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("---->"+result.getMethod().getMethodName()+"<--end--");
		test.log(Status.PASS, result.getMethod().getMethodName()+"---->COMPLETED<----");
	}

	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		
		TakesScreenshot ts1 = (TakesScreenshot)BaseClass.sdriver;
		String filepath = ts1.getScreenshotAs(OutputType.BASE64);
		
		//File src = new File("./screenshot/amazon.png");
		String time = new Date().toString().replace(".", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(filepath, testname+"_"+time);
//		try {
//			File src = new File("./screenshot/"+testname+time+".png");
//			FileHandler.copy(temp, src);
//		} catch (IOException e) {	
//			e.printStackTrace();
//		}
		test.log(Status.FAIL, result.getMethod().getMethodName()+"---->FAILED<----");
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
}
