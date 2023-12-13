package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {

	
	//Sometime it work and sometime it throws a timeout exception  
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		Actions action=new Actions(driver);
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
		
		//To mouseover
		Wait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-link-accountList']")));
		
		WebElement path=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		action.moveToElement(path).build().perform();
		
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Sent keys in capital
		WebElement ele= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		action.click(ele).keyDown(Keys.SHIFT).sendKeys("samsung").build().perform();
		
		//to double click
		//actions.-------.doubleClick().built().perform();
		
		
		
		//to right click
		//action.--------contextClick().built().perform();



	}

}
