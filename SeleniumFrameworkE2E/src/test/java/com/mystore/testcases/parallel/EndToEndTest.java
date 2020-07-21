package com.mystore.testcases.parallel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.parallel.BaseClassForParallelTesting;
import com.mystore.pageobjects.parallel.AddToCartPageParallel;
import com.mystore.pageobjects.parallel.AddressPageParallel;
import com.mystore.pageobjects.parallel.IndexPageParallel;
import com.mystore.pageobjects.parallel.LoginPageParallel;
import com.mystore.pageobjects.parallel.OrderConfirmationPageParallel;
import com.mystore.pageobjects.parallel.OrderPageParallel;
import com.mystore.pageobjects.parallel.OrderSummaryPageParallel;
import com.mystore.pageobjects.parallel.PaymentPageParallel;
import com.mystore.pageobjects.parallel.SearchResultPageParallel;
import com.mystore.pageobjects.parallel.ShippingPageParallel;
import com.mystore.utility.Log;

public class EndToEndTest extends BaseClassForParallelTesting {

	IndexPageParallel indexPage;
	SearchResultPageParallel searchResultPage;
	AddToCartPageParallel addToCartPage;
	OrderPageParallel orderPage;
	LoginPageParallel loginPage;
	AddressPageParallel addressPage;
	ShippingPageParallel shippingPage;
	PaymentPageParallel paymentPage;
	OrderSummaryPageParallel orderSummaryPage;
	OrderConfirmationPageParallel orderConfirmationPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = "Regression")
	public void endToEnd() {

		Log.startTestCase("endToEnd");
		indexPage = new IndexPageParallel();
		Log.info("Entering text in search textbox");
		searchResultPage = indexPage.searchProduct("t-shirt");
		Log.info("Clicking on product");
		addToCartPage = searchResultPage.clickOnProduct();
		Log.info("Entering Quantity");
		addToCartPage.enterQuantity("2");
		Log.info("Selecting Size");
		addToCartPage.selectSize("M");
		Log.info("Clicking on Add To Cart");
		addToCartPage.clickOnAddToCart();
		Log.info("Clicking on Checkout");
		orderPage = addToCartPage.clickOnCheckout();
		Log.info("Clicking on Checkout");
		loginPage = orderPage.clickOnCheckout();
		Log.info("Entering Username and Password");
		addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("Clicking on Checkout");
		shippingPage = addressPage.clickOnCheckout();
		Log.info("Clicking on terms checkbox");
		shippingPage.checkTerms();
		Log.info("Clicking on Checkout");
		paymentPage = shippingPage.clickOnCheckout();
		Log.info("Clicking on Payment Method");
		orderSummaryPage = paymentPage.clickOnPaymentMethod();
		Log.info("Clicking on Confirm Order");
		orderConfirmationPage = orderSummaryPage.clickOnConfirmOrder();

		Log.info("Verifying Order Confirmation");
		String orderConfirmActualMsg = orderConfirmationPage.validateOrderConfirmation();
		String orderConfirmExpectedMsg = "Your order on My Store is complete.";
		Assert.assertEquals(orderConfirmActualMsg, orderConfirmExpectedMsg);
		Log.info("Order Confirmation is verified successfully");
		
		Log.endTestCase("endToEnd");
	}
}
