package com.mystore.pageobjects.parallel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.parallel.BaseClassForParallelTesting;

public class LoginPageParallel extends BaseClassForParallelTesting {

	@FindBy(id = "email")
	WebElement emailAddress;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "email_create")
	WebElement emailNewAccount;

	@FindBy(id = "SubmitCreate")
	WebElement createAccountBtn;

	public LoginPageParallel() {
		PageFactory.initElements(getDriver(), this);
	}

	public HomePageParallel login(String emailAdd, String pwd) {

		emailAddress.sendKeys(emailAdd);
		password.sendKeys(pwd);
		signInBtn.click();
		return new HomePageParallel();
	}
	
	public AddressPageParallel login1(String emailAdd, String pwd) {

		emailAddress.sendKeys(emailAdd);
		password.sendKeys(pwd);
		signInBtn.click();
		return new AddressPageParallel();
	}
	
	public AccountCreationPageParallel createNewAccount(String newEmail) {
		emailNewAccount.sendKeys(newEmail);
		createAccountBtn.click();
		return new AccountCreationPageParallel();	
	}
}
