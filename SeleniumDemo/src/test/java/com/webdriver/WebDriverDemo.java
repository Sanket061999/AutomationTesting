package com.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverDemo {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver","path of chrome according to
		// version of chrome");
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver_115\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		// System.setProperty("webdriver.ie.driver","path of ie driver according to
		// version");
		// webdriver.gecko.driver for FIREFOX // webdriver.ie.driver for IE

		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		System.out.println("-------------");
		System.out.println(driver.getTitle()); // use to validate the title of page
		System.out.println("-------------");
		driver.get("https://in.search.yahoo.com/?fr2=inr");
		
		System.out.println(driver.getCurrentUrl()); // used to validate we are landed on correct page
		System.out.println("-------------");

		//driver.navigate().back(); // going back to previous page
		
		//driver.navigate().forward();
		
		//System.out.println(driver.getPageSource());
		System.out.println("-------------");
		

		//System.out.println(driver.getCurrentUrl()); // used to validate we are landed on correct page
	//	System.out.println("-------------");
		// driver.close(); close current current browser
		//driver.quit(); // close current all browser opened by automation script

	}
}
