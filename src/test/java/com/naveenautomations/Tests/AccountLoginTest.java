package com.naveenautomations.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.Utils.ExcelUtils;
import com.naveenautomation.Utils.Utils;
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
		yp = new YourStorePage(webDriver, true);
		yp.clickMyAccountBtn();
		accountLogin = yp.clickloginBtn();
	}

	@Test(dataProvider = "LoginData",priority = 1)
	public void verifyCustomerLogin(String userName, String password){
		MyAccountPage map = accountLogin.login(userName, password);
		Utils.sleep(2000);
		Assert.assertEquals(map.getTextFromMyAccount(), "My Account");
	}
	
	// testing comment

	
	public void test1() {
		Utils.sleep(3000);
		Assert.assertTrue(false);
	}

	@DataProvider(name = "LoginData")
	String[][] dataProviderToLogin() throws Exception {
		String filePath = "./Book1.xlsx";
		int row = ExcelUtils.getRowsCount(filePath, "Sheet3");
		int col = ExcelUtils.getColumnCount(filePath, "Sheet3", row);

		String[][] logindata = new String[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				logindata[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet3", i, j);
			}
		}

		return logindata;

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
