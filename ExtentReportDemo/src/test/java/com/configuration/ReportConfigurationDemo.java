package com.configuration;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportConfigurationDemo {

	public static void main(String[] args) throws IOException {
		ExtentReports extentreport = new ExtentReports();
		File f = new File("report.html");
		ExtentSparkReporter sparkReports = new ExtentSparkReporter(f);
		ExtentSparkReporterConfig confi = sparkReports.config();
		confi.setTheme(Theme.DARK);
		confi.setReportName("MY TEST REPORT");
		confi.setDocumentTitle("MY TEST DOCUMENT");
		confi.setCss(".badge-primary{background-color:#FF0000}");
		confi.setJs("document.getElementsByClassName(\"logo\")[0].style.display='none';");

		extentreport.attachReporter(sparkReports);

		extentreport.createTest("Test case 1", "Test cases 1 Desc")
		.assignAuthor("Sanket").assignCategory("Smoke")
		.assignDevice("Chrome 99")
		.pass("This TC is passed");

		extentreport.createTest("Test case 2", "Test cases 2 Desc").assignAuthor("Shiwam").assignCategory("Sanity")
		.assignDevice("Edge 99").fail("This TC is failed");

		extentreport.flush();
		Desktop.getDesktop().browse(f.toURI());

	}

}
