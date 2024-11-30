package com.sevenrmartsupermarket.tests;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUserTest extends Base {
	DashBoardPage dashboardpage;
	LoginPage loginpage;
	AdminUserPage adminuserpage;
	
	@Test
	public void verifyClickNewUser() {
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");
		String username=GeneralUtility.getRandomUsername();
		String password=GeneralUtility.getRandomPassword();		
		dashboardpage = new DashBoardPage(driver);
		adminuserpage=new AdminUserPage(driver);
		dashboardpage.clickAdminMoreInfo();	
		String actualPageTitle=adminuserpage.getTitleAdminUser();
		String expectedPageTitle="Admin Users";
		Assert.assertEquals(actualPageTitle, expectedPageTitle);		
		adminuserpage.clickNewBtn();
		adminuserpage.enterUserName(username);
		adminuserpage.enterPassword(password);
		adminuserpage.selectUserType();
		adminuserpage.clickUserType();
		adminuserpage.saveUser();
				
	}
	
	@Test
	public void verifySearchUser() {
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage = new DashBoardPage(driver);
		adminuserpage=new AdminUserPage(driver);
		dashboardpage.clickAdminMoreInfo();	
		adminuserpage.clickSearchButton();
		adminuserpage.enterSearchName("Isela Hills");
		adminuserpage.clickSearchMenu();
		adminuserpage.clickSearchType("admin");
		adminuserpage.bottomSearchUser();	
		List<String> actualTableSearchValues = adminuserpage.getTableOfSearchedUser();
		List<String> expectedTableSearchValues = new ArrayList<String>();
		expectedTableSearchValues.add("Isela Hills");
		expectedTableSearchValues.add("admin");
		expectedTableSearchValues.add("Inactive");
		expectedTableSearchValues.add("Details");
		expectedTableSearchValues.add("");
		expectedTableSearchValues.add("");
		Assert.assertEquals(actualTableSearchValues, expectedTableSearchValues);
		
	}
	
	
	@Test
	public void verifyAdminUserDeleteBtn()
	{
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage = new DashBoardPage(driver);
		dashboardpage.clickAdminMoreInfo();
		adminuserpage = new AdminUserPage(driver);
		String actualDeleteMsg = adminuserpage.deleteUserFromAdminTable("Farha");
		String expectedAlertDeleteMsg = "Alert!User Deleted Successfully";
		Assert.assertEquals(actualDeleteMsg, expectedAlertDeleteMsg);
		
	}
		
}
