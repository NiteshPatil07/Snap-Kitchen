package Utility_Package;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listners extends Utility_Class implements ITestListener
{
	public ExtentTest test ; 
	

	@Override
	public void onTestStart(ITestResult result) 
	{
	        
		 System.out.println("Test is started");
		
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		  test.pass("Test is Pass");
	
		System.out.println("Test is Success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		test.fail("Test is Failed");
		
		try {
			Capturescreenshot(driver,result.getMethod().getMethodName()+".PNG");
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		System.out.println("Test is Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is Skipped");
	
	}	
}
