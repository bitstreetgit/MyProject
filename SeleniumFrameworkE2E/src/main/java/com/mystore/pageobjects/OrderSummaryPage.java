package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass {

	@FindBy(xpath = "//*[text()='I confirm my order']")
	WebElement confirmOrderBtn;

	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}

	public OrderConfirmationPage clickOnConfirmOrder() {
		confirmOrderBtn.click();
		return new OrderConfirmationPage();
	}
}
