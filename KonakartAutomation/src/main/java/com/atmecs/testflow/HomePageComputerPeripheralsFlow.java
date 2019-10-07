package com.atmecs.testflow;

import com.atmecs.constants.Locators;
import com.atmecs.helpers.WebUtility;

public class HomePageComputerPeripheralsFlow {
	static Locators locaters = new Locators();

	public void clickComputerPeripherals() {
		WebUtility.clickElement(Locators.getLocators("loc.btn.customerPeripherals"));
		WebUtility.explicitWait(Locators.getLocators("loc.btn.customerPeripherals"));
	}

	public void selectPricing(int value) {
		WebUtility.scrollBySpacebar();
		// WebUtility.clickElement(Locators.getLocators("loc.pricingRoller.price"));
		WebUtility.setAttributeValue(Locators.getLocators("loc.pricingRoller.price"), value);
		WebUtility.explicitWait(Locators.getLocators("loc.btn.customerPeripherals"));
	}
}
