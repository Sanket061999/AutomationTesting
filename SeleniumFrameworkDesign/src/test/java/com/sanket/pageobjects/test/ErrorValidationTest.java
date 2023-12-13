package com.sanket.pageobjects.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sanket.pageobjects.CartPage;
import com.sanket.pageobjects.ProductCatalogue;
import com.sanket.pageobjects.testcomponent.BaseTest;
import com.sanket.pageobjects.testcomponent.Retry;

public class ErrorValidationTest extends BaseTest {
	
	@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws IOException,InterruptedException{
		landingPage.loginApplication("sanket333deshmukh@gmail.com", "VishwasPatil");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	}

	@Test
	public void productErrorValidation() throws IOException {
		String prodName="ZARA COAT 3";
		ProductCatalogue productCatalog=landingPage.loginApplication("sanket333deshmukh@gmail.com","Sanket@937063");
		productCatalog.addProductToCart(prodName);
		CartPage cartpage=productCatalog.goToCartPage();
		Boolean match=cartpage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
		
	}
}
