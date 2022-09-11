package com.naveenautomations.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.Pages.AccountLogin;
import com.naveenautomations.Pages.RegisterAccountPage;
import com.naveenautomations.Pages.YourStorePage;

public class RegisterAccountPageTest extends TestBase {

	YourStorePage yp;
	AccountLogin accountLogin;
	RegisterAccountPage registerAccountPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		yp = new YourStorePage(webDriver, true);
		yp.clickMyAccountBtn();

	}

	@Test
	public void registrartionTest() throws InterruptedException {
		registerAccountPage = yp.clickregisterBtn();
		registerAccountPage.clicksubmitButton();
		System.out.println(registerAccountPage.textWarningMessage());
		String[] a = registerAccountPage.messagesText();
		org.testng.Assert.assertEquals(registerAccountPage.textWarningMessage(),
				"Warning: You must agree to the Privacy Policy!", "NOT MATCHING");
		org.testng.Assert.assertEquals(a[0], "First Name must be between 1 and 32 characters!", "NAME NOT MATCHING");
		org.testng.Assert.assertEquals(a[1], "Last Name must be between 1 and 32 characters!",
				"LAST NAME NOT MATCHING");
		org.testng.Assert.assertEquals(a[2], "E-Mail Address does not appear to be valid!", "E-MAIL NOT MATCHING");
		org.testng.Assert.assertEquals(a[3], "Telephone must be between 3 and 32 characters!",
				"TELEPHONE NOT MATCHING");
		org.testng.Assert.assertEquals(a[4], "Password must be between 4 and 20 characters!", "PASSWORD NOT MATCHING");

//		Thread.sleep(2000);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
