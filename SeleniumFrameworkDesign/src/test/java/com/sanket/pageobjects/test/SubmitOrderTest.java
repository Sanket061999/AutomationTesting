package com.sanket.pageobjects.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sanket.pageobjects.CartPage;
import com.sanket.pageobjects.CheckoutPage;
import com.sanket.pageobjects.OrderPage;
import com.sanket.pageobjects.ProductCatalogue;
import com.sanket.pageobjects.testcomponent.BaseTest;


public class SubmitOrderTest extends BaseTest {

	String prodName="ZARA COAT 3";
	
	
	@Test(dataProvider = "getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {
	ProductCatalogue productCatalog=landingPage.loginApplication(input.get("email"),input.get("password"));
	
	//	List<WebElement> products=productCatalog.getProductList(); //internally we are calling it in next step
		productCatalog.addProductToCart(input.get("product"));
		CartPage cartpage=productCatalog.goToCartPage();
		Boolean match=cartpage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartpage.goToCheckout();
		checkoutPage.selectCountry("india");
//		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
//		String confirmMessage=confirmationPage.getConfirmationMessage();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		driver.close();
//		
		
		WebElement Submit = driver.findElement(By.cssSelector("a.action__submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript click after waiting for the element to be clickable
		js.executeScript("arguments[0].click();", Submit);

		String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.close();
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistory() {
	
		ProductCatalogue productCatalog=landingPage.loginApplication("sanket333deshmukh@gmail.com","Sanket@937063");
		OrderPage orderPage=productCatalog.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(prodName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "sanket333deshmukh@gmail.com");
//		map1.put("pass", "Sanket@937063");
//		map1.put("product", "ZARA COAT 3");
		
//		HashMap<String,String> map2=new HashMap<String,String>();
//		map2.put("email", "deshmukhsanket33@gmail.com");
//		map2.put("pass", "Sanket@937063");
//		map2.put("product", "ADIDAS ORIGINAL");
				
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");	
		return new Object[][]{{data.get(0)},{data.get(1)}};
		}

}
