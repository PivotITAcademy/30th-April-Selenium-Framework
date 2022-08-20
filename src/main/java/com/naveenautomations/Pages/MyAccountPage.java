package com.naveenautomations.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "#content h2")
	private WebElement myaccountText;

	public String getTextFromMyAccount() {
		return myaccountText.getText();
	}

}
