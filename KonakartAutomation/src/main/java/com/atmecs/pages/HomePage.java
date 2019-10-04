package com.atmecs.pages;

import org.testng.Assert;

import com.atmecs.constants.Locators;
import com.atmecs.constants.ValidatingData;
import com.atmecs.helpers.WebUtility;

//in this class, validation of different functionality is validated of the homepage of yatra.com flight bookings

public class HomePage {

	static Locators loc = new Locators();
	ValidatingData data = new ValidatingData();

	/**
	 * In this method i'm validating the functionality of redirecting the page is
	 * correct.
	 * 
	 */
	public void isRedirectionCorrect() {

		String title = WebUtility.getTitle();
		Assert.assertEquals(title, ValidatingData.getValidatingData("homepage_Title"));
		System.out.println("Redirection is on the correct page");
	}

	/**
	 * In this method i'm validating the product is present or not after you hit the
	 * any search button
	 * 
	 * @param product name
	 */

	public void isProductAvailable(String expectedProductName) {
		String actualProductName = WebUtility
				.getText(Locators.getLocators("loc.text.productName").replace("[dummytext]", expectedProductName));
		Assert.assertEquals(actualProductName, expectedProductName, "Product is not present");
		System.out.println("input functionality is correct");

	}

	/**
	 * In this method i'm validating the footer is displayed or not after you hit
	 * the any header button
	 * 
	 * @param errormsg
	 */

	public void isErrorMessageDisplayed(String errorMsg) {
		String actualMsg = WebUtility.getText(Locators.getLocators("loc.errorMsg.product"));
		Assert.assertEquals(actualMsg, errorMsg, "msg is not displayed");
		System.out.println("Error message functionality is correct");

	}
}
