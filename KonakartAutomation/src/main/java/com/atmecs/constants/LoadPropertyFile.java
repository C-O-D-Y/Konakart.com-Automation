package com.atmecs.constants;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.utils.ReadPropertiesFile;

/**
 * In this class, property file is loaded for getting locators.
 */
public class LoadPropertyFile {

	public static Properties locators;
	public static Properties validate;

	/**
	 * In this constructor, reading of property file is being done.
	 */

	public LoadPropertyFile() {
		try {
			locators = ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);
		} catch (IOException e) {
			System.out.println("Locater file not found");
		}
		try {
			validate = ReadPropertiesFile.loadProperty(FilePath.VALIDATION_FILE);
		} catch (IOException e) {
			System.out.println("Validation file not found");
		}
	}
}
