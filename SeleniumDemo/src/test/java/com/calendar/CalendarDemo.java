package com.calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.setProperty("WebDriver.chrome.driver","C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.path2usa.com/travel-companion/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		 @SuppressWarnings("rawtypes")
		Wait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='form-field-travel_comp_airline']")));
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_airline']")).click();
		
		
		
		
		  @SuppressWarnings("rawtypes")
		Wait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='form-field-travel_comp_date']")));
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		
		
		//To select 19 jan
		
		
	//	driver.findElement(By.xpath("//label[@class='elementor-field-label']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText());

	}

}
