package com.atmecs.constants;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.utils.ReadPropertiesFile;

/**
 * In this class, property file is loaded for getting locators.
 */
public class Locators {
	static Properties homePageProperty;

	/**
	 * In this constructor, reading of property file is being done.
	 */
	public Locators() {
		try {
			homePageProperty = ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * In this method, locator data from the property file is taken and returning
	 * the value.
	 * 
	 * @param key
	 */
	public static String getLocators(String key) {

		String value = homePageProperty.getProperty(key);
		return value;
	}

//	public static void main(String[] args) {
//		YatraFlightBookingLocators details = new YatraFlightBookingLocators();
//		System.out.println(YatraFlightBookingLocators.getLocators("loc.btn.roundTrip"));
//	}
}
