package com.screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullScreenshotDemo {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		TakesScreenshot screenshot= ((TakesScreenshot)driver);
		
		//or  
		
		
		//ChromeDriver driver= new ChromeDriver();
		//ChromeDriver screenshot=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40l));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40l)); // mandatory
		
		driver.get("https://www.google.com/");
		
		
		File srcFile1=screenshot.getScreenshotAs(OutputType.FILE);
		File destFile1=new File("C:\\Selenium_4\\SeleniumSession2Demo\\Screenshots\\fullscr11.png");
		
		FileUtils.copyFile(srcFile1, destFile1);

		
		
		WebElement section=driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]"));
		File srcFile2=section.getScreenshotAs(OutputType.FILE);
		File destFile2=new File("C:\\Selenium_4\\SeleniumSession2Demo\\Screenshots\\sectionscr22.png");
		
		FileUtils.copyFile(srcFile2, destFile2);
		
		
		
		WebElement field=driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[2]"));
		File srcFile3=field.getScreenshotAs(OutputType.FILE);
		File destFile3=new File("C:\\Selenium_4\\SeleniumSession2Demo\\Screenshots\\filedscr33.png");
		
		FileUtils.copyFile(srcFile3, destFile3);
	
	}

}
