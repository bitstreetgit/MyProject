package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {

	@FindBy(xpath = "//*[text()='Proceed to checkout']")
	WebElement checkOutBtn;

	public AddressPage() {
		PageFactory.initElements(driver, this);
	}

	public ShippingPage clickOnCheckout() {
		checkOutBtn.click();
		return new ShippingPage();
	}

}
