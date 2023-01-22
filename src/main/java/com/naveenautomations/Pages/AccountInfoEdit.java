package com.naveenautomations.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Utils.ProxyDriver;

public class AccountInfoEdit extends Page {
	
	private static final String PAGE_URL = "Newsletter Subscription";

	public AccountInfoEdit(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	private By continueBtn = By.cssSelector("input[type=\"submit\"]");

	public MyAccountPage clickcontinueBtn() {
		((ProxyDriver) wd).click(continueBtn);
		return new MyAccountPage(wd, true);
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub
		
	}

}
