package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.Data_Providers;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageContactPage;

public class ManageContactTest extends Base {

	DashBoardPage dashboardpage;
	LoginPage loginpage;
	ManageContactPage managecontactpage;

	

	@Test(dataProvider = "editmanagecontact", dataProviderClass = Data_Providers.class)
	public void verifyEditEntriesUsingDataProviders(String phoneNum, String gmail, String address, String time,
			String limit) throws InterruptedException {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");
		managecontactpage = new ManageContactPage(driver);
		dashboardpage.clickEachCategory("list-contact");
		String actualAlertMsg = managecontactpage.EditContactUsingDataProvider(phoneNum, gmail, address, time, limit);
		String expectedAlertMsg = "Alert!Contact Updated Successfully";
		Assert.assertEquals(actualAlertMsg, expectedAlertMsg);
	}
}