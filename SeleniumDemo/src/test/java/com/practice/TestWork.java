package com.practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWork {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40l));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40l)); // mandatory
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		String ExpDate="14";
		String ExpMonth="June";
		String ExpYear="2024";
		
		String ActMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String ActYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		
		while(!(ActMonth.equals(ExpMonth) && ActYear.equals(ExpYear))) {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			ActMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			ActYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		}
		List<WebElement> list=driver.findElements(By.xpath("//table[1]/tbody[1]/tr/td"));
		Iterator<WebElement> itr=list.iterator();
		while(itr.hasNext()) {
			WebElement ele=itr.next();
			
			if(ExpDate.equals(ele.getText())) {
				ele.click();
			}
		}
		

	}

}
