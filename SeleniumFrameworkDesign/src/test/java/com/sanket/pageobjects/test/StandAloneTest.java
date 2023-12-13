package com.sanket.pageobjects.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneTest {

	public static void main(String[] args) {
		String prodName="ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");	
		driver.findElement(By.id("userEmail")).sendKeys("sanket333deshmukh@gmail.com");	
		driver.findElement(By.id("userPassword")).sendKeys("Sanket@937063");
		driver.findElement(By.id("login")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));		
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ng-animating")));		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));		
		
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cardProduct=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cardProduct.stream().anyMatch(cardProd->cardProd.getText().equalsIgnoreCase(prodName));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
			
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();


		WebElement Submit = driver.findElement(By.cssSelector("a.action__submit"));

		// Wait for the element to be clickable using WebDriverWait
		wait.until(ExpectedConditions.elementToBeClickable(Submit));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Execute JavaScript click after waiting for the element to be clickable
		js.executeScript("arguments[0].click();", Submit);


		
		//or
		//WebElement Submit = driver.findElement(By.cssSelector("action__submit")).click();


		String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
		
	}

}
