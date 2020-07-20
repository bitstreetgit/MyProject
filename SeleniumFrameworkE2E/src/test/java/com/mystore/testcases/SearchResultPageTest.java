package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;

	@BeforeMethod
	public void setUp() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void productAvailabiltyTest() {

		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		boolean flag = searchResultPage.isProductAvailable();
		Assert.assertTrue(flag);
	}
}
