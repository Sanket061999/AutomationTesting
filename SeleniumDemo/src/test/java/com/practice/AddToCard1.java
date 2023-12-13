package com.practice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCard1 {

	
	public static void main(String[] args) {
		
		String singleveggie=null;
		String SingleunformattedName=null;
		int count=0;
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);   it is duprecated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] veggis= {"Cauliflower","Beetroot","Brocolli"};
		List<String> lveggis=Arrays.asList(veggis);
		List<WebElement> list=driver.findElements(By.xpath("//h4[@class='product-name']"));
		for(int i=0;i<list.size();i++) {
			String[] unformattedName=list.get(i).getText().split(" ");
			 SingleunformattedName=unformattedName[0].trim();
			
			if(lveggis.contains(SingleunformattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				count++;
			}
			if(count==lveggis.size()) {
				break;
			}
			
			
		}
		
	}
}
