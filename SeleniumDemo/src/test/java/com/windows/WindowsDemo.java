package com.windows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsDemo {

	public static void main(String[] args) {
		System.setProperty("WebDriver.chrome.driver","C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://support.google.com/");
		driver.findElement(By.xpath("//span[@itemprop='title']")).click();
		System.out.println(driver.getTitle());
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String>itr=windows.iterator();
		String parentWindow=itr.next();
		String childWindow=itr.next();
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		


		
		
		

	}

}
