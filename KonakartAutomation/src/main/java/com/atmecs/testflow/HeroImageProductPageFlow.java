package com.atmecs.testflow;

import com.atmecs.constants.Locators;
import com.atmecs.helpers.WebUtility;

/**
 * Class maintain the flow of the test to the second page by clicking on the
 * hero image
 */
public class HeroImageProductPageFlow {

	/**
	 * Method click on the hero image at the home page
	 */
	public static void clickHeroImage() {
		WebUtility.clickElement(Locators.getLocators("loc.img.heroImage"));
		WebUtility.explicitWait(Locators.getLocators("loc.text.heroImageProductName"));
	}

	/**
	 * Method click on the product specification bar
	 */
	public static void clickProductSpecification() {

		WebUtility.clickElement(Locators.getLocators("loc.btn.specification"));
	}

	/**
	 * Method click on the Customer reviews bar
	 */
	public static void clickCustomerReviews() {

		WebUtility.clickElement(Locators.getLocators("loc.btn.customerReviews"));
	}

	/**
	 * Method select the dropdown by index of the sorting options
	 */
	public static void selectSortingDropdown(int sortingOrder) {
		WebUtility.selectDropdownByIndex(Locators.getLocators("loc.dpdn.sort"), sortingOrder);
		WebUtility.explicitWait(Locators.getLocators("loc.text.heroImageProductName"));
	}

}
