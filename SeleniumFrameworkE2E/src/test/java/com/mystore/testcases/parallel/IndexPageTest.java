package com.mystore.testcases.parallel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.parallel.BaseClassForParallelTesting;
import com.mystore.pageobjects.parallel.IndexPageParallel;

public class IndexPageTest extends BaseClassForParallelTesting {

	IndexPageParallel indexPage;

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
	public void verifyLogo() {
		indexPage = new IndexPageParallel();
		boolean logo = indexPage.validateLogo();
		Assert.assertTrue(logo);
	}

	@Test(groups = "Smoke")
	public void verifyTitle() {
		String actualTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(actualTitle, "My Store");
	}
}
