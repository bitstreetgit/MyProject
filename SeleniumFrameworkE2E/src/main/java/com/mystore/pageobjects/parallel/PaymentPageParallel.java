package com.mystore.pageobjects.parallel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.parallel.BaseClassForParallelTesting;

public class PaymentPageParallel extends BaseClassForParallelTesting {

	@FindBy(xpath = "//*[@title='Pay by bank wire']")
	WebElement payByBankWire;

	@FindBy(xpath = "//*[@title='Pay by check.']")
	WebElement payByCheck;

	public PaymentPageParallel() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderSummaryPageParallel clickOnPaymentMethod() {
		payByBankWire.click();
		return new OrderSummaryPageParallel();
	}
	
}
