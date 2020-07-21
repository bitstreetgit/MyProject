package com.mystore.testcases.parallel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.parallel.BaseClassForParallelTesting;
import com.mystore.pageobjects.parallel.AccountCreationPageParallel;
import com.mystore.pageobjects.parallel.IndexPageParallel;
import com.mystore.pageobjects.parallel.LoginPageParallel;
import com.mystore.utility.Log;

public class AccountCreationPageTest extends BaseClassForParallelTesting {

	IndexPageParallel indexPage;
	LoginPageParallel loginPage;
	AccountCreationPageParallel accountCreatePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = "Sanity")
	public void VerifyCreatAccountPageTest() {
		
		Log.startTestCase("VerifyCreatAccountPageTest");
		indexPage = new IndexPageParallel();
		Log.info("Clicking on SignIn link");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Entering new email address");
		accountCreatePage = loginPage.createNewAccount("bitstreet11@gmail.com");
		Log.info("Verifying Create Account is displaying");
		boolean result = accountCreatePage.validateAccountCreatePage();
		Assert.assertTrue(result);
		Log.info("Create Account is displayed");
		Log.endTestCase("VerifyCreatAccountPageTest");
	}
}
