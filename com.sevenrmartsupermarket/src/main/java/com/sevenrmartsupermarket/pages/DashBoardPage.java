package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class DashBoardPage {
	WebDriver driver;
	GeneralUtility generalutility = new GeneralUtility();
	@FindBy(xpath = "//div[@class='info']")
	private WebElement profileName;
	@FindBy(xpath = "//p[text()='Admin Users']/../../div/following-sibling::a")
	private WebElement adminUserMoreInfo;
	@FindBy(xpath = "//h3//following-sibling::p")
	List<WebElement> allCategory;
	@FindBy(xpath = "//li//a[contains(text(),'Home')]")
	WebElement homeButton;
	@FindBy(xpath = "//div[@class='inner']//p[starts-with(text(),'Category')]/../../div//following-sibling::a")
	WebElement categoryMoreInfoLink;
	@FindBy(xpath = "//a[contains(text(),'More info ')]")
	List<WebElement> alMoreInfoLink;
	@FindBy(xpath = "//p[text()='Admin Users']/../../div/following-sibling::a")
	WebElement clickAdminMoreInfo;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return profileName.getText();
	}

	public AdminUserPage clickAdminMoreInfo() {
		clickAdminMoreInfo.click();
		return new AdminUserPage(driver);

	}

	public List<String> getAllCategoryNames() {
		List<String> actualCategoryNames = new ArrayList<String>();
		actualCategoryNames = generalutility.getTextOfElements(allCategory);
		return actualCategoryNames;

	}

	public void clickHomeButton() {
		homeButton.click();
	}

}
