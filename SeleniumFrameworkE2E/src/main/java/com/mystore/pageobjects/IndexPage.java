package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;

	@FindBy(id = "search_query_top")
	WebElement searchProductBox;

	@FindBy(name = "submit_search")
	WebElement searchBtn;

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickOnSignIn() {
		signInBtn.click();
		return new LoginPage();
	}

	public boolean validateLogo() {
		return myStoreLogo.isDisplayed();
	}

	public String getMyStoreTitle() {
		return driver.getTitle();
	}

	public SearchResultPage searchProduct(String productName) {
		searchProductBox.sendKeys(productName);
		searchBtn.click();
		return new SearchResultPage();
	}
}
