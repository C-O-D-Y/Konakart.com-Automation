package com.atmecs.constants;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.utils.ReadPropertiesFile;

/**
 * In this class, property file is loaded for validation
 */
public class ValidatingData {
	static Properties Property;

	/**
	 * In this constructor, reading of property file is being done
	 */
	public ValidatingData() {
		try {
			// calling loadProperty method by giving file path to get property
			Property = ReadPropertiesFile.loadProperty(FilePath.VALIDATION_FILE);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * In this method, validation data from the property file is taken
	 * 
	 * @param key
	 */
	public static String getValidatingData(String key) {
		String value = Property.getProperty(key);
		return value;
	}
}
