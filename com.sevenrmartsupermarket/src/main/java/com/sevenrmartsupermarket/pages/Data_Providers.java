package com.sevenrmartsupermarket.pages;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;



public class Data_Providers {
	ExcelReader excelreader = new ExcelReader();

	
	
	@DataProvider(name = "editmanagecontact") 
	public Object[][] manageContactEdit() {
		excelreader.setExcelFile("DataProviderForManageContact", "Sheet1");
		return excelreader.getMultidimentionalData(1, 5);
	}

	

}