package com.naveenautomations.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.Pages.AccountInfoEdit;
import com.naveenautomations.Pages.AccountLogin;
import com.naveenautomations.Pages.ContactUsPage;
import com.naveenautomations.Pages.MyAccountPage;
import com.naveenautomations.Pages.YourStorePage;

public class ContactUsPageTest extends TestBase {
	
	
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
		ContactUsPage contactUsPage = myAccountPage.clickcustomerServiceBtn();
		contactUsPage.clickcontinueBtn();
		Assert.assertEquals(contactUsPage.getTextFromErrorMsg(), "Name must be between 3 and 32 characters!", "Message not matched");
		 Thread.sleep(5000);
	}
	
	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
