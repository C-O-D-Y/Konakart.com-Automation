package com.atmecs.testScripts;

import org.apache.log4j.Logger;
import org.testng.TestNGException;
import org.testng.annotations.Test;

import com.atmecs.constants.Locators;
import com.atmecs.constants.ValidatingData;
import com.atmecs.dataProvider.TestDataProvider;
import com.atmecs.logReports.LogReport;
import com.atmecs.pages.HomePage;
import com.atmecs.testBase.TestBase;
import com.atmecs.testflow.HomePageFlow;

/*
*Class validates the functionality of homepage header buttons functionality
*/
public class HomePagetestscripts extends TestBase {
	Logger log;
	Locators locators = new Locators();
	static HomePage home = new HomePage();
	ValidatingData data = new ValidatingData();

	/*
	 * Test validates the homepage redirection of the konakart.com
	 */
	@Test(priority = 1)
	public void homePageRedirection() {
		log = Logger.getLogger(HomePagetestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("HomepageRedirection");
		log.info("Starting Redirection validation");
		home.isRedirectionCorrect();
		log.info("Redirection is on the correct page");
		log.info("Starting the homepage testing");
	}

	// method validate the availability of the product
	@Test(priority = 2, dataProvider = "rightCategory", dataProviderClass = TestDataProvider.class)
	public void validateProductAvilability(String category, String product, String expectedProductName)
			throws InterruptedException {
		try {
			HomePageFlow.clickCategory(category);
			HomePageFlow.selectProduct(product);
			log = Logger.getLogger(HomePagetestscripts.class);
			// WebUtility.explicitWait(Locators.getLocators("loc.btn.services"));
			home.isProductAvailable(expectedProductName);
			log.info("Validation done");
		} catch (TestNGException exception) {
			log.info("Input Functionality is not correct");
			exception.printStackTrace();
		}
	}

	/*
	 * Test validates the error msg is displayed when giving wrong input
	 */
	@Test(priority = 3, dataProvider = "wrongCategory", dataProviderClass = TestDataProvider.class)
	public void validateErrorMessage(String category, String product, String errorMsg) throws InterruptedException {
		try {
			HomePageFlow.clickCategory(category);
			HomePageFlow.selectProduct(product);
			log = Logger.getLogger(HomePagetestscripts.class);
			// WebUtility.explicitWait(Locators.getLocators("loc.btn.services"));
			home.isErrorMessageDisplayed(errorMsg);
			log.info("Validation done");
		} catch (TestNGException exception) {
			log.info("Input Functionality is not correct");
			exception.printStackTrace();
		}
	}
}
