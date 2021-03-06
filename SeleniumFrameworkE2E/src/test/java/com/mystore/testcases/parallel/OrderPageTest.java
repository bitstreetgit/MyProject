package com.mystore.testcases.parallel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.parallel.BaseClassForParallelTesting;
import com.mystore.pageobjects.parallel.AddToCartPageParallel;
import com.mystore.pageobjects.parallel.IndexPageParallel;
import com.mystore.pageobjects.parallel.OrderPageParallel;
import com.mystore.pageobjects.parallel.SearchResultPageParallel;
import com.mystore.utility.Log;

public class OrderPageTest extends BaseClassForParallelTesting {

	IndexPageParallel indexPage;
	SearchResultPageParallel searchResultPage;
	AddToCartPageParallel addToCartPage;
	OrderPageParallel orderPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = "Regression")
	public void verifyTotalPrice() {

		Log.startTestCase("verifyTotalPrice");
		indexPage = new IndexPageParallel();
		Log.info("Entering text in search textbox");
		searchResultPage = indexPage.searchProduct("t-shirt");
		Log.info("Clicking on product");
		addToCartPage = searchResultPage.clickOnProduct();
		Log.info("Entering Quantity");
		addToCartPage.enterQuantity("2");
		Log.info("Selecting Size");
		addToCartPage.selectSize("M");
		Log.info("Clicking on Add To Cart");
		addToCartPage.clickOnAddToCart();
		Log.info("Clicking on Checkout");
		orderPage = addToCartPage.clickOnCheckout();
		Log.info("Verifying Total Price");
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice * 2) + 2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		Log.info("Total Price verified successfully");
		Log.endTestCase("verifyTotalPrice");
	}
}
