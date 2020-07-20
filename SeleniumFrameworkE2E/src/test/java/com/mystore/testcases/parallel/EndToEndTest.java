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

		indexPage = new IndexPageParallel();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnCheckout();
		loginPage = orderPage.clickOnCheckout();
		addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage = addressPage.clickOnCheckout();
		shippingPage.checkTerms();
		paymentPage = shippingPage.clickOnCheckout();
		orderSummaryPage = paymentPage.clickOnPaymentMethod();
		orderConfirmationPage = orderSummaryPage.clickOnConfirmOrder();

		String orderConfirmActualMsg = orderConfirmationPage.validateOrderConfirmation();
		String orderConfirmExpectedMsg = "Your order on My Store is complete.";
		Assert.assertEquals(orderConfirmActualMsg, orderConfirmExpectedMsg);

	}
}
