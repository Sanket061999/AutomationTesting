package com.sanket.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sanket.abstractcomponent.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//Old
	
	//We have new way to use page object model is using PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail; // both work as same this one is just a shortcut and simplied method we need to write 		PageFactory.initElements(driver,this); in the constractor

	@FindBy(id="userPassword")
	WebElement userPasswordEle; 	
	
	@FindBy(id="login")
	WebElement submit; 

	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage; 	
	
	public ProductCatalogue loginApplication(String username,String password) {
		userEmail.sendKeys(username);
		userPasswordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		waitforWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
