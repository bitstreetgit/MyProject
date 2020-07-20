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

		indexPage = new IndexPageParallel();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateMyWishList();
		Assert.assertTrue(result);
	}

	@Test(groups = "Smoke")
	public void orderHistoryTest() {

		indexPage = new IndexPageParallel();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);
	}
}
