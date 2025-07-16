package Task_BC_LI;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Task_LI implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("execute onStart IS");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("execute onFinish IS");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("execute onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("execute onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("execute onTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("execute onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("execute onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("execute onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("execute onStart ITC");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("execute onFinsih ITC");
	}

	
}
