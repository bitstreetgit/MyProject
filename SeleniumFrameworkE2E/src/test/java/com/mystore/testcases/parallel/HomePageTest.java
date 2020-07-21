package com.mystore.testcases.parallel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.parallel.BaseClassForParallelTesting;
import com.mystore.pageobjects.parallel.HomePageParallel;
import com.mystore.pageobjects.parallel.IndexPageParallel;
import com.mystore.pageobjects.parallel.LoginPageParallel;
import com.mystore.utility.Log;

public class HomePageTest extends BaseClassForParallelTesting {

	IndexPageParallel indexPage;
	LoginPageParallel loginPage;
	HomePageParallel homePage;

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
	public void wishListTest() {

		Log.startTestCase("wishListTest");
		indexPage = new IndexPageParallel();
		Log.info("Clicking on SignIn link");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Entering Username And Password");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("Verifying WishList is displaying");
		boolean result = homePage.validateMyWishList();
		Assert.assertTrue(result);
		Log.info("WishList is displayed");
		Log.endTestCase("wishListTest");
	}

	@Test(groups = "Smoke")
	public void orderHistoryTest() {

		Log.startTestCase("orderHistoryTest");
		indexPage = new IndexPageParallel();
		Log.info("Clicking on SignIn link");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Entering Username And Password");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("Verifying Order History is displaying");
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);
		Log.info("WishList is displayed");
		Log.endTestCase("orderHistoryTest");
	}
}
