package com.mystore.pageobjects.parallel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.parallel.BaseClassForParallelTesting;

public class ShippingPageParallel extends BaseClassForParallelTesting {

	@FindBy(id = "cgv")
	WebElement terms;

	@FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	WebElement checkOutBtn;

	public ShippingPageParallel() {
		PageFactory.initElements(getDriver(), this);
	}

	public void checkTerms() {
		terms.click();
	}

	public PaymentPageParallel clickOnCheckout() {
		checkOutBtn.click();
		return new PaymentPageParallel();
	}

}
