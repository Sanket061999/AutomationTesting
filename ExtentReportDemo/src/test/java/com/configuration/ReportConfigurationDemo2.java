package com.configuration;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportConfigurationDemo2 {

	public static void main(String[] args) throws IOException {
		ExtentReports extentreport = new ExtentReports();
		File f = new File("report.html");
		ExtentSparkReporter sparkReports = new ExtentSparkReporter(f);

		sparkReports.loadJSONConfig(new File("./src/test/resources/extent-report-configuration.json"));

		// above for json and below for xml //Use json as its lightweight

		// sparkReports.loadJSONConfig(new File("./src/test/resources/extent-report-configuration.xml"));

		extentreport.attachReporter(sparkReports);

		extentreport.createTest("Test case 1", "Test cases 1 Desc").assignAuthor("Sanket").assignCategory("Smoke")
				.assignDevice("Chrome 99").pass("This TC is passed");

		extentreport.createTest("Test case 2", "Test cases 2 Desc").assignAuthor("Shiwam").assignCategory("Sanity")
				.assignDevice("Edge 99").fail("This TC is failed");

		extentreport.flush();
		Desktop.getDesktop().browse(f.toURI());
	}

}
