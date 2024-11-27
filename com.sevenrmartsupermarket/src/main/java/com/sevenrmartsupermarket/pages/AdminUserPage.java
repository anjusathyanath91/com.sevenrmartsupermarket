package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUserPage {
	
	WebDriver driver;
	@FindBy (xpath="//h1[text()='Admin Users']")
	WebElement adminUserTitle;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement adminUserNewBtn;
	
	
	public AdminUserPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleAdminUser() {
		
		return adminUserTitle.getText();
		
	
	}
	
	public void clickNewBtn() {
		adminUserNewBtn.click();
		
	}

}
