package com.mystore.pageobjects.parallel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.parallel.BaseClassForParallelTesting;

public class AddressPageParallel extends BaseClassForParallelTesting {

	@FindBy(xpath = "//*[text()='Proceed to checkout']")
	WebElement checkOutBtn;

	public AddressPageParallel() {
		PageFactory.initElements(getDriver(), this);
	}

	public ShippingPageParallel clickOnCheckout() {
		checkOutBtn.click();
		return new ShippingPageParallel();
	}

}
