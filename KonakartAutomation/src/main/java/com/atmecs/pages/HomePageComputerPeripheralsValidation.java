package com.atmecs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.constants.Locators;
import com.atmecs.constants.ValidatingData;
import com.atmecs.helpers.WebUtility;

public class HomePageComputerPeripheralsValidation {
	static Locators loc = new Locators();
	ValidatingData data = new ValidatingData();

	public void validatePrice() {
		ArrayList<WebElement> prices = (ArrayList<WebElement>) WebUtility
				.getElementsList(Locators.getLocators("loc.getPrices.products"));
		int values = prices.size();

		System.out.println("Values=" + values);
		String priceRange = WebUtility.getText(Locators.getLocators("loc.slider.priceRange"));
		System.out.println("Price range=" + priceRange);
		String[] priceValues = priceRange.split("-");
		System.out.println("priceValues are" + priceValues[0] + "  " + priceValues[1]);
		String minimumPrice = priceValues[0].replace("$", "");
		System.out.println("minimum price " + minimumPrice);
		String maximumPrice = priceValues[1].replace("$", "");
		System.out.println("Maximum price " + maximumPrice);

		for (WebElement prices1 : prices) {
			System.out.println(prices1.getText());
			String productPrice = prices1.getText();
			System.out.println("product price=" + productPrice);
			String productPriceValidate = productPrice.replace("$", "");
			System.out.println("Product price validate" + productPriceValidate);
			System.out.println(Float.parseFloat(minimumPrice));
			System.out.println(Float.parseFloat(productPriceValidate));
			System.out.println(Float.parseFloat(maximumPrice));

			Assert.assertTrue(
					Float.parseFloat(minimumPrice) <= Float.parseFloat(productPriceValidate)
							&& Float.parseFloat(productPriceValidate) <= Float.parseFloat(maximumPrice),
					"Price range slider sorting is not correct");
		}
	}
}
