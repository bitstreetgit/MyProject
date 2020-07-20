package com.mystore.pageobjects.parallel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.parallel.BaseClassForParallelTesting;

public class OrderSummaryPageParallel extends BaseClassForParallelTesting {

	@FindBy(xpath = "//*[text()='I confirm my order']")
	WebElement confirmOrderBtn;

	public OrderSummaryPageParallel() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderConfirmationPageParallel clickOnConfirmOrder() {
		confirmOrderBtn.click();
		return new OrderConfirmationPageParallel();
	}
}
