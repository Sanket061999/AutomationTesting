package com.alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		
		
		driver.findElement(By.xpath("//button[@id='promptBox']")).click();
		
		Alert promptBoxAlert = driver.switchTo().alert();
		
		System.out.println(promptBoxAlert.getText());
		promptBoxAlert.sendKeys("Sanket");
		Thread.sleep(3000);
		promptBoxAlert.accept();
		//promptBoxAlert.dismiss();
		System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText());
		
	
	}

}
