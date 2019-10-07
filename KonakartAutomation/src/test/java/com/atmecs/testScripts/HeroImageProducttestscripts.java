package com.atmecs.testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.constants.Locators;
import com.atmecs.constants.ValidatingData;
import com.atmecs.logReports.LogReport;
import com.atmecs.pages.HeroImageProductValidation;
import com.atmecs.pages.HomePage;
import com.atmecs.testBase.TestBase;
import com.atmecs.testflow.HeroImageProductPageFlow;

public class HeroImageProducttestscripts extends TestBase {
	Logger log;
	Locators locators = new Locators();
	HomePage home = new HomePage();
	ValidatingData data = new ValidatingData();
	HeroImageProductValidation heroImg = new HeroImageProductValidation();

	/*
	 * Test validates the homepage redirection of the konakart.com
	 */
	@Test(priority = 5)
	public void homePageRedirection() {
		log = Logger.getLogger(HeroImageProducttestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("HomepageRedirection");
		log.info("Starting Redirection validation");
		home.isRedirectionCorrect();
		log.info("Redirection is on the correct page");
		log.info("Starting the Hero Image Product Validation testing");

	}

	/*
	 * Test validates the content of the product description and specification
	 */
	@Test(priority = 6)
	public void validateContents() {
		log = Logger.getLogger(HeroImageProducttestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("Validating the content of the product");
		HeroImageProductPageFlow.clickHeroImage();
		heroImg.validateDescriptionContent();
		log.info("Content validation is correct");
		HeroImageProductPageFlow.clickProductSpecification();
		heroImg.validateSpecificationContent();
		log.info("Content is present");
		log.info("Starting Sorting functionality testing");
	}

	/*
	 * Test maintain the flow to the second page by clicking customer reviews.
	 */
	@Test(priority = 7)
	public void validateSortingFunctionality() {
		log = Logger.getLogger(HeroImageProducttestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("Validating the Sorting functionality");
		HeroImageProductPageFlow.clickCustomerReviews();
		log.info("Content is present");
		log.info("Starting Sorting functionality testing");
	}
	/*
	 * Test validates the sorting functionality of the date selection type
	 */

	@Test(priority = 8)
	public void validateSortingByDate() {
		log = Logger.getLogger(HeroImageProducttestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("Validating the Sorting functionality");
		HeroImageProductPageFlow.selectSortingDropdown(0);
		heroImg.validateDate(1);
		HeroImageProductPageFlow.selectSortingDropdown(1);
		heroImg.validateDate(2);
		log.info("sorting is correct");
	}

	/*
	 * Test validates the sorting functionality of the rating selection type
	 */
	@Test(priority = 9)
	public void validateSortingByRating() {
		log = Logger.getLogger(HeroImageProducttestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("Validating the Sorting functionality");
		HeroImageProductPageFlow.selectSortingDropdown(2);
		heroImg.validateStarRating(3);
		HeroImageProductPageFlow.selectSortingDropdown(3);
		heroImg.validateStarRating(4);
		log.info("sorting is correct");
	}
}
