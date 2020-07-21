package com.mystore.testcases.parallel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.parallel.BaseClassForParallelTesting;
import com.mystore.pageobjects.parallel.AddToCartPageParallel;
import com.mystore.pageobjects.parallel.IndexPageParallel;
import com.mystore.pageobjects.parallel.SearchResultPageParallel;
import com.mystore.utility.Log;

public class AddToCartPageTest extends BaseClassForParallelTesting {

	IndexPageParallel indexPage;
	SearchResultPageParallel searchResultPage;
	AddToCartPageParallel addToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = { "Regression", "Sanity" })
	public void addToCartTest() {
		
		Log.startTestCase("addToCartTest");
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
		Log.info("Verifying Add To Cart");
		boolean result = addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
		Log.info("Add To Cart is verified successfully");
		Log.endTestCase("addToCartTest");

	}
}
