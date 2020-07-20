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

		indexPage = new IndexPageParallel();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result = addToCartPage.validateAddToCart();
		Assert.assertTrue(result);

	}
}
