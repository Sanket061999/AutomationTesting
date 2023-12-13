package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));	
		driver.get("https://jqueryui.com/slider/");
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//*[@id='content']/iframe"))));
		
		WebElement mainSlider=driver.findElement(By.xpath("//div[@id='slider']"));
		WebElement slider=driver.findElement(By.xpath("//div[@id='slider']/span"));
		int width=mainSlider.getSize().getWidth()/2;
		Actions act= new Actions(driver);
	
		act.dragAndDropBy(slider, width/2, 0).build().perform();
		
		

	
	}

}
