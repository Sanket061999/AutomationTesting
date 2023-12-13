package com.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimpleDropdownDemo2 {

	public static void main(String[] args){
		
	//	Here as well the notification is comming we need to handle this
	//	program is correct 
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.singaporeair.com/en_UK/in/home#/book/bookflight");
	
		driver.findElement(By.xpath("//input[@id='flightPassengers1']")).click();	
		
	
	
		int i=1;
		while(i<5) {
			driver.findElement(By.xpath("//body[1]/div[1]/div[7]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/button[1]")).click();
			
		i++;
	}
	
		//child
		driver.findElement(By.xpath("//body/div[1]/div[7]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/button[1]")).click();		
		
		
		//infants
		driver.findElement(By.xpath("//body/div[1]/div[7]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/button[1]")).click();		
		
	//removing the adult	
		driver.findElement(By.xpath("//body/div[1]/div[7]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")).click();		
		
		
	
}
}