package com.naveenautomations.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.Pages.AccountLogin;
import com.naveenautomations.Pages.MyAccountPage;
import com.naveenautomations.Pages.YourStorePage;

public class AccountLoginTest extends TestBase {

	YourStorePage yp;
	AccountLogin accountLogin;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
		accountLogin = yp.clickloginBtn();
	}

	@Test
	public void verifyCustomerLogin() {
		MyAccountPage map = accountLogin.login("user10@gmail.com", "Qwerty123");
		Assert.assertEquals(map.getTextFromMyAccount(), "My Account");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
