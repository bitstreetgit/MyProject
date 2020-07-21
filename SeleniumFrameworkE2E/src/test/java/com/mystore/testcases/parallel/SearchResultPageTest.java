package com.mystore.testcases.parallel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.parallel.BaseClassForParallelTesting;
import com.mystore.pageobjects.parallel.IndexPageParallel;
import com.mystore.pageobjects.parallel.SearchResultPageParallel;
import com.mystore.utility.Log;

public class SearchResultPageTest extends BaseClassForParallelTesting {

	IndexPageParallel indexPage;
	SearchResultPageParallel searchResultPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = "Smoke")
	public void productAvailabiltyTest() {

		Log.startTestCase("productAvailabiltyTest");
		indexPage = new IndexPageParallel();
		Log.info("Verifying product is displaying");
		searchResultPage = indexPage.searchProduct("t-shirt");
		boolean flag = searchResultPage.isProductAvailable();
		Assert.assertTrue(flag);
		Log.info("Product is dispalyed");
		Log.endTestCase("productAvailabiltyTest");
	}
}
