package com.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DynamicDropdownDemo2 {

	public static void main(String[] args) throws InterruptedException {

		//Getting Error in sending keys for searching the city need to handle the web notification
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		int count=0;
		String toCity="Nagpur";
		String fromCity="Nagpur ";
		driver.get("https://www.makemytrip.com/railways/");
		
		Thread.sleep(5000l);
		driver.findElement(By.xpath("//a[id='webklipper-publisher-widget-container-notification-close-div']")).click();
		driver.findElement(By.id("fromCity")).sendKeys("Nag");
		Thread.sleep(3000l);
		List<WebElement> flist = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
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
