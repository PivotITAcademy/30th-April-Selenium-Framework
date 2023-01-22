package com.naveenautomations.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.Pages.AccountInfoEdit;
import com.naveenautomations.Pages.AccountLogin;
import com.naveenautomations.Pages.MyAccountPage;
import com.naveenautomations.Pages.YourStorePage;

public class AccountInfoEditTest extends TestBase {
	
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
		AccountInfoEdit accountInfoEdit = myAccountPage.clickaccountInfoBtn();
		myAccountPage = accountInfoEdit.clickcontinueBtn();
		Assert.assertEquals(myAccountPage.getTextFromaccountInfoSucsMsg(), "Success: Your account has been successfully updated.", "Account info not updated");
		 Thread.sleep(5000);
	}
	
	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
