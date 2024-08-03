package com.Fieldy.TestUtility;

import com.Fieldy.TestBase.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtils {

	
	public static ExtentReports generateReport()
	{
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(Constants.reportsPath+"//extent"+System.currentTimeMillis()+".html");
		
		ExtentReports reports=new ExtentReports();
		
		sparkReporter.config().setDocumentTitle("ZaigoInfoTech Automation");
		
		sparkReporter.config().setReportName("Automation Results of Fieldy Project");
		
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		sparkReporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss, EEEE");
		
		reports.attachReporter(sparkReporter);
		
		return reports;
	}
}
