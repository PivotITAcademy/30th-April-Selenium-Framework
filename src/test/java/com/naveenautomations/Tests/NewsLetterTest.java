package com.naveenautomations.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.Pages.AccountLogin;
import com.naveenautomations.Pages.MyAccountPage;
import com.naveenautomations.Pages.NewsLetterPage;
import com.naveenautomations.Pages.YourStorePage;

public class NewsLetterTest extends TestBase {

	YourStorePage yp;
	AccountLogin accountLogin;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		yp = new YourStorePage(webDriver, true);
		yp.clickMyAccountBtn();
		accountLogin = yp.clickloginBtn();
	}

	@Test
	public void newsLetterTest() throws InterruptedException {
		myAccountPage = accountLogin.login("oo7@gmail.com", "PasswordReloaded");
		NewsLetterPage newsLetterPage = myAccountPage.clicknewLetterBtn();
		myAccountPage = newsLetterPage.clickcontinueBtn();
		System.out.println("Printing this " + myAccountPage.textnewsLetterSubscriptionMessage());
		Assert.assertEquals(myAccountPage.textnewsLetterSubscriptionMessage(),
				"Success: Your newsletter subscription has been successfully updated!", "Unable to subscribe");
		// Thread.sleep(5000);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
