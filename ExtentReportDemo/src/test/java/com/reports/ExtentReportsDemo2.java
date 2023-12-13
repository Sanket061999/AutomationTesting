package com.reports;

import java.awt.Desktop;
import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo2 {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		File f = new File("test.html");
		ExtentSparkReporter reports = new ExtentSparkReporter(f);
		extentReports.attachReporter(reports);


		extentReports.createTest("Test 1").log(Status.FAIL, "fail1")
		.log(Status.INFO,"info 1")
		.log(Status.PASS,"pass 1")
		.log(Status.PASS,"pass 1");
	
		extentReports.flush();
		Desktop.getDesktop().browse(f.toURI()); 

	}

}
