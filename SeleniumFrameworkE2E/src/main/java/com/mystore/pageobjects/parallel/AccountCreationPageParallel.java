package com.mystore.pageobjects.parallel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.parallel.BaseClassForParallelTesting;

public class AccountCreationPageParallel extends BaseClassForParallelTesting {

	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement formTitle;

	public AccountCreationPageParallel() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateAccountCreatePage() {

		return formTitle.isDisplayed();
	}
}
