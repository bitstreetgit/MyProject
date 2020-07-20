package com.mystore.pageobjects.parallel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.parallel.BaseClassForParallelTesting;

public class SearchResultPageParallel extends BaseClassForParallelTesting {

	@FindBy(xpath = "//*[@id='center_column']//img")
	WebElement productResult;

	public SearchResultPageParallel() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean isProductAvailable() {
		return productResult.isDisplayed();
	}

	public AddToCartPageParallel clickOnProduct() {
		productResult.click();
		return new AddToCartPageParallel();
	}
}
