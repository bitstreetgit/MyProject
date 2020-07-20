package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {

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

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String emailAdd, String pwd) {

		emailAddress.sendKeys(emailAdd);
		password.sendKeys(pwd);
		signInBtn.click();
		return new HomePage();
	}
	
	public AddressPage login1(String emailAdd, String pwd) {

		emailAddress.sendKeys(emailAdd);
		password.sendKeys(pwd);
		signInBtn.click();
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		emailNewAccount.sendKeys(newEmail);
		createAccountBtn.click();
		return new AccountCreationPage();	
	}
}
