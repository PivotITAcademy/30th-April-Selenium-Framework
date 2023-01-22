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

public class MyAccountPage extends Page {

	private static final String PAGE_URL = "account/account";

	public MyAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	//Locators
	private By newLetterBtn = By.cssSelector("div.list-group a:nth-of-type(12)");
	private By myaccountText = By.cssSelector("#content h2");
	private By newsLetterSubscriptionMessage = By.cssSelector("#account-account div");
	private By accountInfoBtn = By.cssSelector("div#content ul:first-of-type li:first-of-type a");
	private By accountInfoSucsMsg = By.cssSelector("div#account-account div.alert");
	private By customerServiceBtn = By.cssSelector("div.col-sm-3:nth-of-type(2) li:nth-of-type(1) a");



	public String getTextFromMyAccount() {
		return ((ProxyDriver) wd).getText(myaccountText);
	}
	public String getTextFromaccountInfoSucsMsg() {
		return ((ProxyDriver) wd).getText(accountInfoSucsMsg);
	}

	public NewsLetterPage clicknewLetterBtn() {
		((ProxyDriver) wd).click(newLetterBtn);
		return new NewsLetterPage(wd, true);
	}
	
	public ContactUsPage clickcustomerServiceBtn() {
		((ProxyDriver) wd).click(customerServiceBtn);
		return new ContactUsPage(wd, true);
	}
	
	public AccountInfoEdit clickaccountInfoBtn() {
		((ProxyDriver) wd).click(accountInfoBtn);
		return new AccountInfoEdit(wd, true);
	}
	
	public String textnewsLetterSubscriptionMessage() {
		return ((ProxyDriver) wd).getText(newsLetterSubscriptionMessage);
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
