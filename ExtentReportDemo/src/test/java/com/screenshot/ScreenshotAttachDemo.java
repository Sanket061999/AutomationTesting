package com.screenshot;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ScreenshotAttachDemo {
	static WebDriver driver;

	public static void main(String[] args) throws Exception{
		ExtentReports extentreport=new ExtentReports();	
		File f=new File("report.html");
		ExtentSparkReporter sparkReports=new ExtentSparkReporter(f);
		extentreport.attachReporter(sparkReports);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		String base64codeScrenshot=captureScreenshot();
		String path=captureScreenshot("google.jpg");
				
		driver.get("https://www.google.com/");

		extentreport
		.createTest("Screenshot test 1","This is attaching SS testcase at test level")
		.info("This is info message")
		.addScreenCaptureFromBase64String(base64codeScrenshot);
		
		extentreport
		.createTest("Screenshot test 2","This is attaching SS testcase at test level")
		.info("This is info message")
		.addScreenCaptureFromBase64String(base64codeScrenshot,"Google Homepage");
	
		extentreport
		.createTest("Screenshot test 3","This is attaching SS testcase at test level")
		.info("This is info message")
		.addScreenCaptureFromPath(path); 
		
		extentreport
		.createTest("Screenshot test 4","This is attaching SS testcase at test level")
		.info("This is info message")
		.addScreenCaptureFromPath(path, "Google Homepage");
		
		
		extentreport
		.createTest("Screenshot test 5","This is attaching SS testcase at test level")
		.info("This is info message")
		.addScreenCaptureFromPath(path, "Google Homepage 1")
		.addScreenCaptureFromPath(path, "Google Homepage 2")
		.addScreenCaptureFromPath(path, "Google Homepage 3")
		.addScreenCaptureFromPath(path, "Google Homepage 4");
		
		
		extentreport
		.createTest("Screenshot test A","This is attaching SS testcase at log level")
		.info("This is info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64codeScrenshot).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64codeScrenshot,"Google home page A").build());
		
		extentreport
		.createTest("Screenshot test B","This is attaching SS testcase at log level")
		.info("This is info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path,"Google home page A").build());
		
		extentreport
		.createTest("Screenshot test C","This is attaching SS testcase at log level") 
		.fail("This is info message",MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail("This is info message",MediaEntityBuilder.createScreenCaptureFromPath(path,"Google home page A").build());
		
		Throwable throwable=new Throwable("This is throwable exception");
		extentreport
		.createTest("Screenshot test D","This is attaching SS testcase at log level") 
		.fail(throwable,MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(throwable,MediaEntityBuilder.createScreenCaptureFromPath(path,"Google home page A").build());
		
		
		extentreport.flush();
		Desktop.getDesktop().browse(f.toURI());
			
		
		System.out.println("1-5 test are for TEST level");
		System.out.println("A-D test are for LOG level");
		
	}
	
	public static String captureScreenshot(String filename) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./Screenshot/"+filename);
		try {
			FileUtils.copyFile(srcFile,destFile );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();
	}
	
	public static String captureScreenshot() {
		TakesScreenshot ts=(TakesScreenshot) driver;
		String base64=ts.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot saved successfully");
		return base64;
	}
}
