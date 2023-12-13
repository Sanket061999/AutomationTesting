package com.wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitDemo {

	public static void main(String[] args) {
        
   	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
			
         WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();

  		
         
          driver.get("http://omayo.blogspot.com/");
         
          driver.findElement(By.className("dropbtn")).click();
          
          WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook")));
    	
          driver.findElement(By.linkText("Facebook")).click();
  

	}

}
