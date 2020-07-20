package com.mystore.pageobjects.parallel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.parallel.BaseClassForParallelTesting;

public class IndexPageParallel extends BaseClassForParallelTesting {

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;

	@FindBy(id = "search_query_top")
	WebElement searchProductBox;

	@FindBy(name = "submit_search")
	WebElement searchBtn;

	public IndexPageParallel() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPageParallel clickOnSignIn() {
		signInBtn.click();
		return new LoginPageParallel();
	}

	public boolean validateLogo() {
		return myStoreLogo.isDisplayed();
	}

	public String getMyStoreTitle() {
		return getDriver().getTitle();
	}

	public SearchResultPageParallel searchProduct(String productName) {
		searchProductBox.sendKeys(productName);
		searchBtn.click();
		return new SearchResultPageParallel();
	}
}
