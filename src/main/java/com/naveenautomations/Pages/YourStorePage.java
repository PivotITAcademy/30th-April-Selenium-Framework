package com.naveenautomations.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.ProxyDriver;
import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;

public class YourStorePage extends TestBase {

	public YourStorePage() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "#top-links ul li:nth-of-type(2) span:first-of-type")
	private WebElement myAccountBtn;

	@FindBy(css = "#top-links ul.dropdown-menu li:last-of-type")
	private WebElement loginBtn;

	public void clickMyAccountBtn() {
		Utils.javascriptClick(myAccountBtn);
	}

	public AccountLogin clickloginBtn() {
		Utils.click(loginBtn);
		return new AccountLogin();
	}

}
