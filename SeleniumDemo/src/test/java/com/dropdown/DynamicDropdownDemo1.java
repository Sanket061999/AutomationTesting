package com.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DynamicDropdownDemo1 {

	public static void main(String[] args) throws InterruptedException {

//		Errors due to popup notification we need to handle this
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		int count=0;
		//String toCity="Nagpur";
		String fromCity="Nagpur";
		driver.get("https://www.redbus.in/");
		Thread.sleep(2000l);
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Na");
		Thread.sleep(3000l);
		List<WebElement> flist = driver.findElements(By.xpath("//ul[@class='sc-dnqmqq eFEVtU']/li"));
		System.out.println("Finding list	"+flist.size());
		System.out.println(flist);
		for (WebElement opt : flist) {
			System.out.println(opt.getText());
			if(opt.getText().contains(fromCity)) {
				opt.click();
				count++;
				break;
			}
		}
		if(count>0) {
			System.out.println(fromCity+" city is selected" );
		}
		else {
			System.out.println("City is not found");
		}
			

	}

}
