package com.Fieldy.TestUtility;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersUtils implements ITestListener{

	ExtentReports reports;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
	
		reports=ReportUtils.generateReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		test=reports.createTest(result.getName());
		test.log(Status.INFO, "Test Got Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test Got Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		String message=result.getThrowable().getMessage();
		System.out.println("Info: - > The project runner class " + name + "Test got Failed");
		
		test.log(Status.FAIL, "Test Got Failed"+":"+message);
		
		DriverUtils.captureScreenShot("fail");
		
		test.addScreenCaptureFromBase64String(DriverUtils.captureScreenShotBASE64(), "Screenshot Captured...");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Got Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		reports.flush();
	}
	

}
