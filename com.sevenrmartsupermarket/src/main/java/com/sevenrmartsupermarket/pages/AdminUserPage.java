package com.sevenrmartsupermarket.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AdminUserPage {

	WebDriver driver;
	WaitUtility waitutility;

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

	@FindBy(xpath = "//select[@id='ut']//option[text()='Staff']")
	WebElement searchUserType;
	
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchUser;
	

	public AdminUserPage(WebDriver driver) {

		this.driver = driver;
		waitutility = new WaitUtility(driver);
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
	
	public void enterSearchName() {
		
		searchUserName.sendKeys("anjusathyanath");

	}

	public void clickSearchMenu() {
		waitutility.waitElementForClickable(searchUserTypeMenu, 50);
		searchUserTypeMenu.click();

	}

	public void clickSearchType() {
		waitutility.waitElementForClickable(searchUserType, 50);
		searchUserType.click();

	}
	
	public void searchUser() {
		waitutility.waitElementForClickable(searchUserType, 50);
		searchUser.click();
		
	}

}
