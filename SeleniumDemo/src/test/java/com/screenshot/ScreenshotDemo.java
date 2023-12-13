package com.screenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDemo{
	public static void main(String[] args)  throws IOException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file1=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File("./Screenshots/Img1.png"));
		
		String base64Code=ts.getScreenshotAs(OutputType.BASE64);
		byte[] byteArray=Base64.getDecoder().decode(base64Code);
		FileOutputStream fo=new FileOutputStream(new File("./Screenshots/Img2.png"));
		fo.write(byteArray);
		fo.close();
		
		
		byte[] byteArr=ts.getScreenshotAs(OutputType.BYTES);
		FileOutputStream fos=new FileOutputStream(new File("./Screenshots/Img3.png"));
		fos.write(byteArr);	
		fos.close();
		
		
		driver.quit();

	}
	

}
