package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginTest() {

		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualUrl = homePage.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualUrl,expectedUrl );
	}
}
