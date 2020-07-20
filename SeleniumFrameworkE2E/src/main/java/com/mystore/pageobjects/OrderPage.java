package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {

	@FindBy(xpath = "//*[@class='cart_unit']/span/span")
	WebElement unitPrice;

	@FindBy(id = "total_price")
	WebElement totalPrice;

	@FindBy(xpath = "//*[text()='Proceed to checkout']")
	WebElement checkoutBtn;

	public OrderPage() {

		PageFactory.initElements(driver, this);
	}

	public Double getUnitPrice() {
		String unitPriceText = unitPrice.getText(); // $16.51
		String unitP = unitPriceText.replaceAll("[^a-zA-Z0-9]", ""); // remove special characters
		Double finalUnitPrice = Double.parseDouble(unitP);// 1651
		return finalUnitPrice / 100;
	}

	public Double getTotalPrice() {
		String totalPriceText = totalPrice.getText(); // $16.51
		String totalP = totalPriceText.replaceAll("[^a-zA-Z0-9]", "");  // remove special characters
		Double finalTotalPrice = Double.parseDouble(totalP);// 1651
		return finalTotalPrice / 100;
	}

	public LoginPage clickOnCheckout() {
		checkoutBtn.click();
		return new LoginPage();
	}
}
