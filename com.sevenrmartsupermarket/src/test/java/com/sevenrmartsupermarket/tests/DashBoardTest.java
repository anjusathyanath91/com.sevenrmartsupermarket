package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;

import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.base.Base;

public class DashBoardTest extends Base {
	DashBoardPage dashboardpage;
	LoginPage loginpage;
	AdminUserPage adminuserpage;

	@Test(groups = "smoke")
	public void verifyAllCardItemNamesOfHomePage() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		loginpage.login("admin", "admin");
		List<String> actualAllCategoryames = dashboardpage.getAllCategoryNames();
		List<String> expectedAllCategoryNames = new ArrayList<>();
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

	@Test
	public void verifyDashBoardMoreInfoButtonIsClickable() throws InterruptedException {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage.clickEachCategory("list-category");
		String actualTabHeadings = dashboardpage.getHeadingsTab();
		String expectedTabHeadings = actualTabHeadings;
		String actualAdminProfileName = dashboardpage.getProfileName();
		String expectedProfileName = "Admin";
		System.out.println(actualAdminProfileName);
		System.out.println(expectedProfileName);
		Assert.assertEquals(actualTabHeadings, expectedTabHeadings);

	}

	

	@Test
	public void verifyDashboardDropDownListItemsClickable() throws InterruptedException {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage.clickDashboardList();
		List<String> actualDashboardElements = dashboardpage.getDashboardListElements();
		List<String> expectedDashboardElements = new ArrayList<String>();
		expectedDashboardElements.add("RR1");
		expectedDashboardElements.add("Manage product");
		expectedDashboardElements.add("cdc");
		Assert.assertEquals(actualDashboardElements, expectedDashboardElements);
		dashboardpage.clickanyDashboardElement();

	}

	@Test
	public void verifyAllDashboardComponentsNames() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage.clickDashboardList();
		List<String> actualComponents = dashboardpage.getAllDashboardAdminComp();
		List<String> expectedComponents = new ArrayList<String>();
		expectedComponents.add("Dashboard");
		expectedComponents.add("Category");
		expectedComponents.add("Sub Category");
		expectedComponents.add("Manage Contact");
		expectedComponents.add("Manage Gift cards &vouchers");
		expectedComponents.add("Admin Users");
		expectedComponents.add("Manage Category");
		expectedComponents.add("Manage Product");
		expectedComponents.add("Manage Footer Text");
		expectedComponents.add("Manage News");
		expectedComponents.add("swd");
		expectedComponents.add("Manage Product");
		Assert.assertEquals(actualComponents, expectedComponents);

	}

	@Test
	public void verifyClickAllDashBoardComp() throws InterruptedException {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage.clickAllDashboardComp("list-footertext");
		String actualTabHeadings = dashboardpage.getHeadingsTab();
		String expectedTabHeadings = actualTabHeadings;
		Assert.assertEquals(actualTabHeadings, expectedTabHeadings);
	}

	@Test
	public void verifyLogoutUserButton() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		loginpage.login("admin", "admin");
		String actual = dashboardpage.clickLogoutUser();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected);
	}

}