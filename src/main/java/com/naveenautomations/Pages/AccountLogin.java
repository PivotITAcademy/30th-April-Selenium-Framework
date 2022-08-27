package com.naveenautomations.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.ProxyDriver;
import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;

public class AccountLogin extends TestBase {
	public AccountLogin() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(id = "input-email")
	private WebElement inputEmailField;

	@FindBy(id = "input-password")
	private WebElement enterPasswordField;

	@FindBy(css = "input[type='submit']")
	private WebElement submitBtn;

	public void enterEmail(String email) {
		Utils.sendKeysUsingJavascript(inputEmailField, email);
	}

	public void enterPassword(String password) {
		Utils.sendKeys(enterPasswordField, password);
	}

	public MyAccountPage clickSubmitBtn() {
		Utils.click(submitBtn);
		return new MyAccountPage();
	}

	public MyAccountPage login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		return clickSubmitBtn();
	}

}
