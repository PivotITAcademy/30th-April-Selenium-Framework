package com.naveenautomations.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.ProxyDriver;
import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;

public class YourStorePage extends Page {

	private static final String PAGE_URL = "common/home";

	public YourStorePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By myAccountBtn = By.cssSelector("#top-links ul li:nth-of-type(2) span:first-of-type");
	private By loginBtn = By.cssSelector("#top-links ul.dropdown-menu li:last-of-type");

	public void clickMyAccountBtn() {
		((ProxyDriver) wd).click(myAccountBtn);
	}

	public AccountLogin clickloginBtn() {
		((ProxyDriver) wd).click(loginBtn);
		return new AccountLogin(wd, true);
	}

	@Override
	protected void isLoaded() throws Error {
		if(!urlContains(wd.getCurrentUrl())) {
			fail("Page didn't load");
		}
	}

	@Override
	public String getPageURL() {
		return String.format("%s%s", getDomain(), PAGE_URL);
	}
}
