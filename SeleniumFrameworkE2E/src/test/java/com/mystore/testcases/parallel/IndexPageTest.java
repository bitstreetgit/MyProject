package com.mystore.testcases.parallel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.parallel.BaseClassForParallelTesting;
import com.mystore.pageobjects.parallel.IndexPageParallel;
import com.mystore.utility.Log;

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

		Log.startTestCase("verifyLogo");
		indexPage = new IndexPageParallel();
		Log.info("Verifying Index page logo");
		boolean logo = indexPage.validateLogo();
		Assert.assertTrue(logo);
		Log.info("Logo is validated successfully");
		Log.endTestCase("verifyLogo");
	}

	@Test(groups = "Smoke")
	public void verifyTitle() {

		Log.startTestCase("verifyTitle");
		Log.info("Verifying Index page title");
		String actualTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(actualTitle, "My Store");
		Log.info("Index page title is verified successfully");
		Log.endTestCase("verifyTitle");
	}
}
