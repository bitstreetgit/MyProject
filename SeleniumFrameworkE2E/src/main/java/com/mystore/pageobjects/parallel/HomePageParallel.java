package com.mystore.pageobjects.parallel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.parallel.BaseClassForParallelTesting;

public class HomePageParallel extends BaseClassForParallelTesting {

	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement myWishList;

	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;

	public HomePageParallel() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

	public boolean validateMyWishList() {
		return myWishList.isDisplayed();
	}

	public boolean validateOrderHistory() {
		return orderHistory.isDisplayed();
	}
}
