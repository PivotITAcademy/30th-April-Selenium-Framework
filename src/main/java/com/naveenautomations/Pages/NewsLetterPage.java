package com.naveenautomations.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Utils.ProxyDriver;

public class NewsLetterPage extends Page {

	private static final String PAGE_URL = "Newsletter Subscription";

	public NewsLetterPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By newsLetterSubscriptionMessage = By.cssSelector("#account-account div i");
	private By continueBtn = By.cssSelector("input[type=\"submit\"]");

	public MyAccountPage clickcontinueBtn() {
		((ProxyDriver) wd).click(continueBtn);
		return new MyAccountPage(wd, true);
	}

}
