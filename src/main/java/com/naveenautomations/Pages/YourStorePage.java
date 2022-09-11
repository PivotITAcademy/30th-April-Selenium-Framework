package com.naveenautomations.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Utils.ProxyDriver;

public class YourStorePage extends Page {

	private static final String PAGE_URL = "common/home";

	public YourStorePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By myAccountBtn = By.cssSelector("#top-links ul li:nth-of-type(2) span:first-of-type");
	private By loginBtn = By.cssSelector("#top-links ul.dropdown-menu li:last-of-type");
	private By registerBtn = By.cssSelector("#top-links ul.dropdown-menu li:first-of-type");

	public void clickMyAccountBtn() {
		((ProxyDriver) wd).click(myAccountBtn);
	}

	public AccountLogin clickloginBtn() {
		((ProxyDriver) wd).click(loginBtn);
		return new AccountLogin(wd, true);
	}

	public RegisterAccountPage clickregisterBtn() {
		((ProxyDriver) wd).click(registerBtn);
		return new RegisterAccountPage(wd, true);
	}

}
