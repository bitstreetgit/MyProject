package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy(xpath = "//*[@title='Pay by bank wire']")
	WebElement payByBankWire;

	@FindBy(xpath = "//*[@title='Pay by check.']")
	WebElement payByCheck;

	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}

	public OrderSummaryPage clickOnPaymentMethod() {
		payByBankWire.click();
		return new OrderSummaryPage();
	}
	
}
