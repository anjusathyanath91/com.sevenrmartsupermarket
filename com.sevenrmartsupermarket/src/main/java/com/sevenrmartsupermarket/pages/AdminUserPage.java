package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AdminUserPage {

	WebDriver driver;
	WaitUtility waitutility;
	PageUtility pageutility;
	GeneralUtility generalutility = new GeneralUtility();

	@FindBy(xpath = "//h1[text()='Admin Users']")
	WebElement adminUserTitle;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement adminUserNewBtn;

	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;

	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropDown;

	@FindBy(xpath = "//select[@id='user_type']//option[text()='Staff']")
	WebElement userTypeName;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;

	@FindBy(xpath = "//a[text()=' Search']")
	WebElement searchButton;

	@FindBy(xpath = "//input[@id='un']")
	WebElement searchUserName;

	@FindBy(xpath = "//select[@id='ut']")
	WebElement searchUserTypeMenu;

	@FindBy(xpath = "//select[@id='ut']")
	WebElement userTypeSelect;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchUser;

	@FindBy(xpath = "//table//tbody//tr//td")
	List<WebElement> searchButtonBelowResultTable;

	@FindBy(xpath = "//table//tbody//tr//td[1]")
	List<WebElement> getAllNamesFromTable;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlert;

	public AdminUserPage(WebDriver driver) {

		this.driver = driver;
		waitutility = new WaitUtility(driver);
		pageutility = new PageUtility(driver);
		PageFactory.initElements(driver, this);
	}

	public String getTitleAdminUser() {
		System.out.println(adminUserTitle.getText());
		return adminUserTitle.getText();

	}

	public void clickNewBtn() {

		adminUserNewBtn.click();

	}

	public void enterUserName(String username) {

		userName.sendKeys(username);

	}

	public void enterPassword(String password) {

		passWord.sendKeys(password);

	}

	public void selectUserType() {
		userTypeName.click();

	}

	public void clickUserType() {

		userTypeName.click();
	}

	public void saveUser() {
		saveButton.click();
	}

	public void clickSearchButton() {

		searchButton.click();
	}

	public void enterSearchName(String pass_Username) {

		searchUserName.sendKeys(pass_Username);

	}

	public void clickSearchMenu() {
		waitutility.waitElementForClickable(searchUserTypeMenu, 50);
		searchUserTypeMenu.click();

	}

	public void clickSearchType(String passUserType) {
		pageutility.selectDropDownByValue(userTypeSelect, passUserType);

	}

	public void bottomSearchUser() {

		searchUser.click();

	}

	public List<String> getTableOfSearchedUser() {
		List<String> tableRowValues = new ArrayList<String>();
		tableRowValues = generalutility.getTextOfElements(searchButtonBelowResultTable);
		System.out.println(tableRowValues);
		return tableRowValues;
	}

	public String deleteUserFromAdminTable(String uname) {
		List<String> allTableNames = generalutility.getTextOfElements(getAllNamesFromTable);
		int index = 0;
		for (index = 0; index < allTableNames.size(); index++) {
			if (uname.equals(allTableNames.get(index))) {
				System.out.println(allTableNames.get(index));
				index++;
				break;
			}
		}

		WebElement deleteActionTable = driver.findElement(By.xpath("//table//tbody//tr[" + index + "]//td[5]//a[3]"));
		pageutility.jsClick(deleteActionTable);
		driver.switchTo().alert().accept();
		String actualDeleteMsg = getDeleteAlertMsg();
		return actualDeleteMsg;
	}

	public String getDeleteAlertMsg() {
		String alertMessage = deleteAlert.getText().substring(2, 8);
		String message = deleteAlert.getText().substring(9);
		String actualMsg = alertMessage + message;
		System.out.println(actualMsg);
		return actualMsg;
	}

}
