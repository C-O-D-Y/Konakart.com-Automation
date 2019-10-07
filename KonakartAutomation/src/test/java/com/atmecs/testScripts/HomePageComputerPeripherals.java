package com.atmecs.testScripts;

import org.apache.log4j.Logger;
import org.testng.TestNGException;
import org.testng.annotations.Test;

import com.atmecs.constants.Locators;
import com.atmecs.constants.ValidatingData;
import com.atmecs.dataProvider.TestDataProvider;
import com.atmecs.logReports.LogReport;
import com.atmecs.pages.HomePage;
import com.atmecs.pages.HomePageComputerPeripheralsValidation;
import com.atmecs.testBase.TestBase;
import com.atmecs.testflow.HomePageComputerPeripheralsFlow;
import com.atmecs.testflow.HomePageFlow;

public class HomePageComputerPeripherals extends TestBase {
	Logger log;
	Locators locators = new Locators();
	static HomePage home = new HomePage();
	ValidatingData data = new ValidatingData();
	HomePageComputerPeripheralsFlow peripheralsFlow = new HomePageComputerPeripheralsFlow();
	HomePageComputerPeripheralsValidation peripheralsValidation = new HomePageComputerPeripheralsValidation();
	/*
	 * Test validates the error msg is displayed when giving graphics cards input
	 * and clicking on search button
	 */

	@Test(priority = 1, dataProvider = "wrongProduct", dataProviderClass = TestDataProvider.class)
	public void validateMessage(String category, String product, String errorMsg) throws InterruptedException {
		logger = extent.startTest("Validating error message functionality");

		try {
			log = Logger.getLogger(HomePageComputerPeripherals.class);
			LogReport.getlogger();
			HomePageFlow.clickCategory(category);
			HomePageFlow.selectProduct(product);

			home.isErrorMessageDisplayed(errorMsg);
			log.info("Validation done");
		} catch (TestNGException exception) {
			log.info("Input Functionality is not correct");
			exception.printStackTrace();
		}
	}

	// method validate the availability of the product graphics cards when selected
	// from the dropdown

	@Test(priority = 2, dataProvider = "rightProduct", dataProviderClass = TestDataProvider.class)
	public void validateProductAvilability(String category, String product, String expectedProductName)
			throws InterruptedException {
		logger = extent.startTest("Validating input functionality");
		try {
			log = Logger.getLogger(HomePageComputerPeripherals.class);
			HomePageFlow.clickCategory(category);
			HomePageFlow.selectProductByDropdown(product);

			home.isProductAvailable(expectedProductName);
			log.info("Validation done");
		} catch (TestNGException exception) {
			log.info("Input Functionality is not correct");
			exception.printStackTrace();
		}
	}

	@Test(priority = 3, dataProvider = "pricing", dataProviderClass = TestDataProvider.class)
	public void validatePricingSortingFunctionality(String xoffset) throws InterruptedException {
		logger = extent.startTest("Validating pricing (sorting) functionality");
		try {
			log = Logger.getLogger(HomePageComputerPeripherals.class);
			peripheralsFlow.clickComputerPeripherals();
			System.out.println(xoffset);
			peripheralsFlow.selectPricing(Integer.parseInt(xoffset));
			peripheralsValidation.validatePrice();
			log.info("Validation done");
		} catch (TestNGException exception) {
			log.info("Input Functionality is not correct");
			exception.printStackTrace();
		}
	}
}
