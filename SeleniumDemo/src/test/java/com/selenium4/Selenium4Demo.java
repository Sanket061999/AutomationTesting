package com.selenium4;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4Demo {

	public static void main(String[] args) {

		// ITS MANDATORY TO IMPORT THE FOLLOWING PACKAGE
		// import static org.openqa.selenium.support.locators.RelativeLocator.*;
		// AS ITS A STATIC PACKAGE IT WILL NOT AUTOMATICALLY IMPORT THE PACKAGE

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		// WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));

		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		//System.out.println(driver.findElement(with(By.tagName("lable")).above(nameEditBox)).getText());

		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		//WebElement dateofBirth =driver.findElement(By.cssSelector("[for='dateofBirth']"));

		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
		//driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();

		WebElement iceCreamLabel = driver
				.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		//WebElement iceCreamLabel =driver
		//	.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		//driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click()
		 

		WebElement rdb = driver.findElement(By.id("inlineRadio1"));
		//WebElement rdb = driver.findElement(By.id("inlineRadio1"));
		 

		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
		//System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());

}

}
