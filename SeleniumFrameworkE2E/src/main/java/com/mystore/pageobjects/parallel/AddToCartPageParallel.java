package com.mystore.pageobjects.parallel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.parallel.BaseClassForParallelTesting;

public class AddToCartPageParallel extends BaseClassForParallelTesting {

	@FindBy(id = "quantity_wanted")
	WebElement quantity;

	@FindBy(id = "group_1")
	WebElement size;

	@FindBy(xpath = "//*[text()='Add to cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//*[@id='layer_cart']//h2/i")
	WebElement addToCartMsg;

	@FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
	WebElement checkoutBtn;

	public AddToCartPageParallel() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}

	public void selectSize(String sz) {

		Select s = new Select(size);
		s.selectByVisibleText(sz);
	}

	public void clickOnAddToCart() {
		addToCartBtn.click();
	}

	public boolean validateAddToCart() {
		waitElement(addToCartMsg);
		return addToCartMsg.isDisplayed();
	}

	public OrderPageParallel clickOnCheckout() {
		waitElement(checkoutBtn);
		checkoutBtn.click();
		return new OrderPageParallel();
	}

}
