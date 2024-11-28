package com.sevenrmartsupermarket.tests;
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
		adminuserpage.enterSearchName();
		adminuserpage.clickSearchMenu();
		adminuserpage.clickSearchType();
		adminuserpage.searchUser();
		
	}
	
		
}
