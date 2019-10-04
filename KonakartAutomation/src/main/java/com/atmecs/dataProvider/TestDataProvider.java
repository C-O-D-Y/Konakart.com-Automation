package com.atmecs.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.constants.FilePath;
import com.atmecs.pages.HomePage;
import com.atmecs.utils.ProvideExcelData;

/**
 * In this class, data is given from the dataprovider
 */
public class TestDataProvider {

	HomePage home = new HomePage();

	/**
	 * In this method, getting the data of the category, product and name of the
	 * product into object array and returning to the calling method
	 */

	@DataProvider(name = "rightCategory")
	public Object[][] getHeader() {
		ProvideExcelData provideData = new ProvideExcelData(FilePath.TESTDATA_FILE, 0);
		Object[][] getData = provideData.provideExcelData();
		return getData;
	}

	/**
	 * In this method, getting the data inside the header(SERVICES) into object
	 * array and returning to the calling method
	 */
	@DataProvider(name = "wrongCategory")
	public Object[][] getOption1() {
		ProvideExcelData provideData = new ProvideExcelData(FilePath.TESTDATA_FILE, 1);
		Object[][] getData = provideData.provideExcelData();
		return getData;
	}

	/**
	 * In this method, calling the method to check the data
	 */
	@Test(priority = 2, dataProvider = "category", dataProviderClass = TestDataProvider.class)
	public void validatefooter(String footer, String footer1, String dh) {
		System.out.println(footer);
		System.out.println(footer1);
		System.out.println(dh);
	}
}