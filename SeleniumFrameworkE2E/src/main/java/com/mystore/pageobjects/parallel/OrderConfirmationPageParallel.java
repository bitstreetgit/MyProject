package com.mystore.pageobjects.parallel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.parallel.BaseClassForParallelTesting;

public class OrderConfirmationPageParallel extends BaseClassForParallelTesting {

	@FindBy(xpath = "//*[text()='Your order on My Store is complete.']")
	WebElement orderConfirmationMsg;

	public OrderConfirmationPageParallel() {
		PageFactory.initElements(getDriver(), this);
	}

	public String validateOrderConfirmation() {
		String confirmMsg =  orderConfirmationMsg.getText();
		return confirmMsg;
	}
}
