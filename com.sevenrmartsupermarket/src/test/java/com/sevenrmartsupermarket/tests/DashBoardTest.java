package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class DashBoardTest extends Base {
	DashBoardPage dashboardpage;
	LoginPage loginpage;
	AdminUserPage adminuserpage;

	@Test(groups="smoke")
	public void verifyAllCategory() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		loginpage.login("admin", "admin");
		String categoryName = "Category";
		List<String> actualAllCategoryames = dashboardpage.getAllCategoryNames();
		List<String> expectedAllCategoryNames = new ArrayList();
		expectedAllCategoryNames.add("Admin Users");
		expectedAllCategoryNames.add("Dashboard");
		expectedAllCategoryNames.add("Category");
		expectedAllCategoryNames.add("Sub Category");
		expectedAllCategoryNames.add("Manage Contact");
		expectedAllCategoryNames.add("Manage Gift cards &vouchers");
		expectedAllCategoryNames.add("Test name");
		expectedAllCategoryNames.add("Manage Product");
		expectedAllCategoryNames.add("Manage News");
		expectedAllCategoryNames.add("Manage Footer Text");
		expectedAllCategoryNames.add("Manage Category");
		Assert.assertEquals(actualAllCategoryames, expectedAllCategoryNames);

	}

	@Test(groups={"smoke","regression"})

	public void verifyAdminMoreInfoClick() {
		loginpage = new LoginPage(driver);
		//dashboardpage = new DashBoardPage(driver);
		dashboardpage=loginpage.login("admin", "admin");
		adminuserpage=dashboardpage.clickAdminMoreInfo();
		String actualAdminTitle=adminuserpage.getTitleAdminUser();
		String expectedAdminTitle="Admin Users";
		Assert.assertEquals(actualAdminTitle, expectedAdminTitle);

	}
	
	
}
