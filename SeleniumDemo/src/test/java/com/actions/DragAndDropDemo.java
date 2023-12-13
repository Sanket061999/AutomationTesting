package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// due to ajax element it will take time to render so we have to use this
			// or may be thing we had search it is directily coming from DB no need to page load so in that case we have to use this
		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println("No of frame are: "+driver.findElements(By.tagName("iframe")).size());
		
		//TO move our focus to iframe as it is inside frame
		WebElement fra=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(fra);
		//driver.switchTo().frame(0);//index=0 =1st frame
		//driver.switchTo().frame(ID_OF_THE_FRAME)
		
		WebElement src=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement tar=driver.findElement(By.xpath("//div[@id='droppable']"));		
		
		Actions action= new Actions(driver);
		action.clickAndHold(src).moveToElement(tar).release().build().perform();
		//action.dragAndDrop(src, tar).build().perform();
		
		driver.switchTo().defaultContent(); //To get back from the frame
		
		
		
		
		
	}

}
