package com.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdownDemo2 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Select opt = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));

		opt.selectByValue("option3"); // inside option tag value tag is present //china
		
		Thread.sleep(2000l);
		
		opt.selectByVisibleText("Option2"); // text present in the html page
	
		Thread.sleep(2000l);
		
		opt.selectByIndex(1);
		
		System.out.println("task completed");

	}
}
