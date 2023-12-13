package com.popupnotification;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PopupHandleDemo {

	public static void main(String[] args) throws InterruptedException {
		HashMap<String,Integer> contentProp=new HashMap<String, Integer>();
		HashMap<String,Object> prefs = new HashMap<String, Object>();
		HashMap<String,Object> profile=new HashMap<String, Object>();
		
		
		contentProp.put("notifications", 2);
		contentProp.put("geolocation", 2);
		contentProp.put("media_stream", 1);
		//0 for ask    1 for allow   2 for block		
		
		
		profile.put("manage_default_content_setting", contentProp);
		prefs.put("profile", profile);
		
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(opt);
		driver.get("https://whatmylocation.com/");
	
		
		System.out.println("Notification Handling program");
		
		
		
	}

}
