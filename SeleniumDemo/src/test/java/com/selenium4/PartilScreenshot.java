package com.selenium4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PartilScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement ele=driver.findElement(By.cssSelector("[name='name']"));
		ele.sendKeys("Sanket");
		
		File f=ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("logo.png"));
		driver.quit();
		
	
		
		
		
		
		
	}

}
