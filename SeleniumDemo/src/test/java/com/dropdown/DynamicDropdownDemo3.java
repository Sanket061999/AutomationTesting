package com.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DynamicDropdownDemo3 {

	public static void main(String[] args) throws InterruptedException {

		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		boolean flag =false;
		String country="India";
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000l);
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("In");
		Thread.sleep(2000l);
		List<WebElement> flist = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		System.out.println("Finding list	"+flist.size());
		System.out.println(flist);
		for (WebElement opt : flist) {
			System.out.println(opt.getText());
			if(opt.getText().equals(country)) {
				opt.click();
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(country+" city is selected" );
		}
		else {
			System.out.println("City is not found");
		}
			

	}

}
