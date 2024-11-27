package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class LoginTest extends Base {

	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	ExcelReader excelreader = new ExcelReader();
	ScreenshotCapture screenshotcapture = new ScreenshotCapture();

	@Test(retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyAdminUserLogin() {

		dashBoardPage = new DashBoardPage(driver);
		excelreader.setExcelFile("Login", "LoginCredentials");
		String readUserName = excelreader.getCellData(0, 1);
		String readPassword = excelreader.getCellData(1, 1);

		System.out.println(readUserName);
		System.out.println(readPassword);

		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");

		String actualProfileName = dashBoardPage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
		// screenshotcapture.takeScreenshot(driver, "Admin");
		System.out.println(GeneralUtility.getRandomName());
		System.out.println(GeneralUtility.getRandomAddress());

	}

}
