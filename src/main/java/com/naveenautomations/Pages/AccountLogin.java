package com.naveenautomations.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class AccountLogin extends TestBase {
	public AccountLogin() {
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(id = "input-email")
	private WebElement inputEmailField;

	@FindBy(id = "input-password")
	private WebElement enterPasswordField;

	@FindBy(css = "input[type='submit']")
	private WebElement submitBtn;

	public void enterEmail(String email) {
		inputEmailField.sendKeys(email);
	}

	public void enterPassword(String password) {
		enterPasswordField.sendKeys(password);
	}

	public MyAccountPage clickSubmitBtn() {
		submitBtn.submit();
		return new MyAccountPage();
	}

	public MyAccountPage login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		return clickSubmitBtn();
	}

}
