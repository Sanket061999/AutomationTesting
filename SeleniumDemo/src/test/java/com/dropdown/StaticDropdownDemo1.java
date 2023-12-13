package com.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdownDemo1 {
	public static void main(String[] args) throws InterruptedException {
		
	
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		

		driver.get("https://testautomationpractice.blogspot.com/");
		Select opt= new Select(driver.findElement(By.xpath("//select[@class='form-control'][@id='country']")));
				
	    opt.selectByValue("china");  // inside option tag value tag is present //china
	  List<WebElement> list=opt.getOptions();
	  for(WebElement ele:list) {
		  System.out.println(ele.getText());
	  }
	    Thread.sleep(4000);
	    opt.selectByVisibleText("India"); //  text present in the html page
	    Thread.sleep(4000);
		opt.selectByIndex(1);// canada
		
	

	}
}
