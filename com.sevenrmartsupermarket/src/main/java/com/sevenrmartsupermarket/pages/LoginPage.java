package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	WaitUtility waitutility;

	Properties properties = new Properties();

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWordField;
	@FindBy(xpath = "//button[contains(text(),'Sign')]")
	private WebElement signInField;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);

		try {

			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void enterUsername(String userName) {
		userNameField.sendKeys(userName);

	}

	public void enterPassWord(String passWord) {
		passWordField.sendKeys(passWord);

	}

	public DashBoardPage clickOnSignInButton() {
		signInField.click();
		// waitutility.waitElementForClickable(signInField, 20);
		return new DashBoardPage(driver);

	}

	public DashBoardPage login(String userName, String password) {

		enterUsername(userName);
		enterPassWord(password);
		clickOnSignInButton();
		return new DashBoardPage(driver);
	}

	public void login() {

		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUsername(userName);
		enterPassWord(password);
		clickOnSignInButton();

	}
}
