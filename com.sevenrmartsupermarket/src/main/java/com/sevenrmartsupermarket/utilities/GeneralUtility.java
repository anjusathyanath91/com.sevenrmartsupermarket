package com.sevenrmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {

	public String get_Attribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String getCssProperty(WebElement element, String attribute) {
		return element.getCssValue(attribute);
	}

	public List<String> getTextOfElements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();
		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}

	public static String getRandomName() {

		Faker faker = new Faker();
		return faker.name().firstName();

	}

	public static String getRandomAddress() {

		Faker faker = new Faker();
		return faker.address().fullAddress();
	}

	public static String getRandomUsername() {
		Faker faker = new Faker();
		return "user_" + faker.name().firstName() + "_" + faker.random().nextInt(1000, 9999);
	}

	public static String getRandomPassword() {
		Faker faker = new Faker();
		return "pass_" + faker.internet().password();
	}

	public static String getTimeStamp() {
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;

	}

	public String getHeadings(WebElement element) {
		return element.getText();
	}
}
