package com.sevenrmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	WebDriver driver;
	WebDriverWait explicitwait;
	public WaitUtility(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public void waitElementForClickable(WebElement element,long time) {
		explicitwait=new WebDriverWait(driver, Duration.ofSeconds(time));
		explicitwait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

}
