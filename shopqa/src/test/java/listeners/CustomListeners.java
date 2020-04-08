package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners implements ITestListener{
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed: " + result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed: " + result.getMethod().getMethodName());
	}

}
