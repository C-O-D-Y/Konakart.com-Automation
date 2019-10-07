package com.atmecs.testflow;

import org.apache.log4j.BasicConfigurator;

import com.atmecs.constants.Locators;
import com.atmecs.helpers.WebUtility;

/**
 * class used to maintain the flow of the homepage of the Konakart.com
 */
public class HomePageFlow {

	static Locators locaters = new Locators();

	/**
	 * Method used to click to the category.
	 */
	public static void clickCategory(String category) throws InterruptedException {
		BasicConfigurator.configure();
		System.out.println(Locators.getLocators("loc.dpdn.search"));
		WebUtility.selectDropdown(Locators.getLocators("loc.dpdn.search"), category);
	}

	/**
	 * Method used to send the product text to select the product.
	 */
	public static void selectProduct(String product) {
		WebUtility.clickAndSendText(Locators.getLocators("loc.textinput.search"), product);
		WebUtility.clickElement(Locators.getLocators("loc.btn.search"));
	
	}

	public static void selectProductByDropdown(String product) {
		WebUtility.clickAndSendText(Locators.getLocators("loc.textinput.search"), product);
		WebUtility
				.explicitWait(Locators.getLocators("loc.inputText.insertGraphicsCards").replace("dummytext", product));
		WebUtility
				.clickElement(Locators.getLocators("loc.inputText.insertGraphicsCards").replace("dummytext", product));
	}
}
