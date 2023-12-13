package com.popupnotification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CopiedNotifications {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://whatmylocation.com/");

	}
}