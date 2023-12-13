package com.tabmodification;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class TabModification {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		ExtentReports extentreport = new ExtentReports();
		File f = new File("report.html");
		ExtentSparkReporter sparkReports = new ExtentSparkReporter(f);
		sparkReports.viewConfigurer().viewOrder()
				.as(new ViewName[] { ViewName.EXCEPTION, ViewName.TEST, ViewName.CATEGORY, ViewName.DASHBOARD
				// ViewName.AUTHOR is removed provide order according to you want

				}).apply();
		// ViewName is enum
		// AUTHOR, CATEGORY, DASHBOARD, DEVICE, EXCEPTION, LOG, TEST;
		extentreport.attachReporter(sparkReports);

		extentreport.createTest("Test case 1", "Test cases 1 Desc").assignAuthor("Sanket").assignCategory("Smoke")
				.assignDevice("Chrome 99").pass("This TC is passed");

		extentreport.createTest("Test case 2", "Test cases 2 Desc").assignAuthor("Shiwam").assignCategory("Sanity")
				.assignDevice("Edge 99").fail("This TC is failed");

		Throwable throwable = new Throwable("This is throwable exception");
		extentreport.createTest("Test case 3", "This is attaching SS testcase at log level").info("exception test")
				.fail(throwable);

		extentreport.flush();
		Desktop.getDesktop().browse(f.toURI());

	}

}
