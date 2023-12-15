package com.selenium4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//driver.switchTo().newWindow(WindowType.TAB);
		//or 
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> itr=handles.iterator();
		String parentWindowID=itr.next();
		String childWindow=itr.next();
		driver.switchTo().window(childWindow);
		driver.get("https://www.landisgyr.com.au/");
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		
		
		

	}

}
