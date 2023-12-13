package com.reports;

import java.awt.Desktop;
import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		File f = new File("test.html");
		ExtentSparkReporter reports = new ExtentSparkReporter(f);
		extentReports.attachReporter(reports);

		// We have two method log() and pass() to add log to provide status like pass etc

		ExtentTest test1 = extentReports.createTest("Test 1");
		test1.pass("Test 1 is passed");

		ExtentTest test2 = extentReports.createTest("Test 2").log(Status.FAIL, "Test 2 is Failed");
		
		ExtentTest test3 = extentReports.createTest("Test 3").skip("Test 3 is Skipped");
		
		extentReports.flush();
		Desktop.getDesktop().browse(f.toURI()); 

	}

}
