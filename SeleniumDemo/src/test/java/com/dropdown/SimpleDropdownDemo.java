package com.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimpleDropdownDemo {

	public static void main(String[] args){
		
		//Having error in xpath and NOT able to handle popup
		//javascript box is getting opened
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		//ChromeOptions opt = new ChromeOptions();
		//opt.addArguments("--disable-notifications");
		//opt.addArguments("disable-notifications"); disable notification
		//opt.addArguments("disable-geolocation");  disable geolocation
		//opt.addArguments("disable-media-stream");  disable microphone or cameta
		
		//
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.switchTo().alert().accept();
	
		
		
		driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[1]"));
		
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int i=1;
		while(i<5) {
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		i++;
	}
		
		driver.findElement(By.xpath("//div[@data-testid='Children-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Infant-testID-plus-one-cta']")).click();
		
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']"));
		
		

}
}