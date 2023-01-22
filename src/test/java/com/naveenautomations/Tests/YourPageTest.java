package com.naveenautomations.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.Pages.AccountLogin;
import com.naveenautomations.Pages.YourStorePage;

public class YourPageTest extends TestBase {

	YourStorePage yp;
	AccountLogin accountLogin;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		yp = new YourStorePage(webDriver, true);
	}

	@Test()
	public void testSomething() {
		yp.clickMyAccountBtn();
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
