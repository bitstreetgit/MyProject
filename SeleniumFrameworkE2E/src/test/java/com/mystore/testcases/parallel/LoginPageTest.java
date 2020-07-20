package com.mystore.testcases.parallel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.parallel.BaseClassForParallelTesting;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.parallel.HomePageParallel;
import com.mystore.pageobjects.parallel.IndexPageParallel;
import com.mystore.pageobjects.parallel.LoginPageParallel;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClassForParallelTesting {

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

	@Test
	public void loginTest() {

		Log.startTestCase("loginTest");
		indexPage = new IndexPageParallel();
		Log.info("Click on SignIn");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter Email Id and Password");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualUrl = homePage.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying User is able to login");
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("Login is suceessful");
		Log.endTestCase("loginTest");
	}

	// Data driven using excel
	@Test(dataProvider = "data", dataProviderClass = DataProviders.class, groups = { "Smoke", "Sanity" })
	public void loginTestFromExcelData(String uname, String pswd) {

		Log.startTestCase("loginTestFromExcelData");
		indexPage = new IndexPageParallel();
		Log.info("Click on SignIn");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter Email Id and Password");
		// homePage =
		// loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage = loginPage.login(uname, pswd);
		String actualUrl = homePage.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying User is able to login");
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("Login is suceessful");
		Log.endTestCase("loginTestFromExcelData");
	}
}
