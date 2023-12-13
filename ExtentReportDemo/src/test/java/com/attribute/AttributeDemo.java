package com.attribute;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttributeDemo {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ExtentReports extentreport=new ExtentReports();	
		File f=new File("report.html");
		ExtentSparkReporter sparkReports=new ExtentSparkReporter(f);
		extentreport.attachReporter(sparkReports);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
			
		driver.get("https://www.google.com/");

		extentreport
		.createTest("Test case 1","Test cases 1 Desc")
		.assignAuthor("Sanket")
		.assignCategory("Smoke")
		.assignDevice("Chrome 99")
		.pass("This TC is passed");

		extentreport
		.createTest("Test case 2","Test cases 2 Desc")
		.assignAuthor("Shiwam")
		.assignCategory("Sanity")
		.assignDevice("Edge 99")
		.fail("This TC is failed");
		
		
		extentreport.flush();
		Desktop.getDesktop().browse(f.toURI()); 
	}

}
