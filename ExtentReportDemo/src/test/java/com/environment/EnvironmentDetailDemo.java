package com.environment;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnvironmentDetailDemo {
	public static void main(String[] args) throws IOException {

		ExtentReports extentreport = new ExtentReports();
		File f = new File("report.html");
		ExtentSparkReporter sparkReports = new ExtentSparkReporter(f);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		Capabilities capability = ((RemoteWebDriver) driver).getCapabilities();
		System.out.println(capability.getBrowserName());
		System.out.println(capability.getBrowserVersion());

		System.getProperties().list(System.out);
		System.out.println("-------------------------------------");
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.version"));

		extentreport.setSystemInfo("OS", System.getProperty("os.name"));
		extentreport.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentreport.setSystemInfo("Browser Name", capability.getBrowserName());
		extentreport.setSystemInfo("Browser Version", capability.getBrowserVersion());

		extentreport.createTest("Test case 1", "Test cases 1 Desc").assignAuthor("Sanket").assignCategory("Smoke")
				.assignDevice("Chrome 99").pass("This TC is passed");

		extentreport.createTest("Test case 2", "Test cases 2 Desc").assignAuthor("Shiwam").assignCategory("Sanity")
				.assignDevice("Edge 99").fail("This TC is failed");

		extentreport.attachReporter(sparkReports);
		extentreport.flush();

		driver.quit();
		Desktop.getDesktop().browse(f.toURI());
	}
}
