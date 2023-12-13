package com.wait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitQuestionDemo {

	public static void main(String[] args) {

		
		String singleveggie=null;
		String SingleunformattedName=null;
		int count=0;
		String promocode="rahulshettyacademy";
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);   it is duprecated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		
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
		
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys(promocode);
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		System.out.println("Is code applied successfully");
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
	
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText().equals("Code applied ..!"));
		
	
		
		
		
	}

}
