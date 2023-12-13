package com.popupnotification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PopupDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		opt.addArguments("--disable--geolocation");
		opt.addArguments("--disable-media-stream");

		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://mictests.com/");
		Thread.sleep(3000l);
		driver.findElement(By.xpath("//button[@id='mic-launcher']")).click();
		Thread.sleep(2000l);
		// driver.quit();

		driver.get("https://webcamtests.com/");
		Thread.sleep(3000l);
		driver.findElement(By.xpath("//button[@id='webcam-launcher']")).click();
		Thread.sleep(2000l);

		driver.get("https://www.justdial.com/");
		Thread.sleep(3000l);

		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000l);

	}

}
