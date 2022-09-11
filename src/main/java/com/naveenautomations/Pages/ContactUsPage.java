package com.naveenautomations.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Utils.ProxyDriver;

public class ContactUsPage extends Page {
	

	public ContactUsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	
	private By continueBtn = By.cssSelector("input[type=\"submit\"]");
	private By errorMsg = By.cssSelector("div.text-danger");

	public void clickcontinueBtn() {
		((ProxyDriver) wd).click(continueBtn);
	}
	
	public String getTextFromErrorMsg() {
		return ((ProxyDriver) wd).getText(errorMsg);
	}

}
