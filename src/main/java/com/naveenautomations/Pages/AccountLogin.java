package com.naveenautomations.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Utils.ProxyDriver;

public class AccountLogin extends Page {

	private static final String PAGE_URL = "account/login";

	public AccountLogin(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By inputEmailField = By.id("input-email");
	private By enterPasswordField = By.id("input-password");
	private By submitBtn = By.cssSelector("input[type='submit']");

	public void enterEmail(String email) {
		((ProxyDriver) wd).sendKeys(inputEmailField, email);
	}

	public void enterPassword(String password) {
		((ProxyDriver) wd).sendKeys(enterPasswordField, password);
	}

	public MyAccountPage clickSubmitBtn() {
		((ProxyDriver) wd).click(submitBtn);
		return new MyAccountPage(wd, true);
	}

	public MyAccountPage login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		return clickSubmitBtn();
	}

	@Override
	protected void isLoaded() throws Error {
		if (!urlContains(wd.getCurrentUrl())) {
			fail("Page didn't load");
		}
	}

	@Override
	public String getPageURL() {
		return String.format("%s%s", getDomain(), PAGE_URL);
	}
}
