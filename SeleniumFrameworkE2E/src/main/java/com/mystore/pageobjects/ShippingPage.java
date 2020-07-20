package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {

	@FindBy(id = "cgv")
	WebElement terms;

	@FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	WebElement checkOutBtn;

	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkTerms() {
		terms.click();
	}

	public PaymentPage clickOnCheckout() {
		checkOutBtn.click();
		return new PaymentPage();
	}

}
