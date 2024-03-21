package E_Commerce.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;
      
public class Listeners extends BaseTest implements ITestListener  {
	// WebDriver driver;
             ExtentReports extent =ExtentReporterNG.getReportObject();
             ExtentTest test;
             ThreadLocal<ExtentTest> extenTest = new ThreadLocal<ExtentTest>();
	 public void onTestStart(ITestResult result) {
		   test = extent.createTest(result.getMethod().getMethodName());
		   extenTest.set(test);
		 
	 }
	 
	 public void onTestSuccess(ITestResult result) {
		 extenTest.get().log(Status.PASS,"Test Passed");
		   
		 
	 }
	 
	 public void onTestFailure(ITestResult result) {
		 extenTest.get().fail(result.getThrowable());
		   String filePath = null;
		   try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} 
		 catch (Exception e) {
			
			e.printStackTrace();
		}
				        
		   
		   try {
			 filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		   extenTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	
	 }
	 
	 public void onFinish(ITestContext context) {
		    extent.flush();
		 
	 }

}
