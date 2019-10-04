package com.atmecs.testBase;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.constants.FilePath;
import com.atmecs.constants.GridConnection;
import com.atmecs.constants.LoadPropertyFile;
import com.atmecs.extentReports.ExtentReport;
import com.atmecs.utils.ReadPropertiesFile;

/**
 * Class loads the web driver according to the config file
 */
public class TestBase extends ExtentReport {

	Properties baseClass;
	String url;
	String nodeUrl;
	String connecton;
	 String browser;
	int downloadFile;
	LoadPropertyFile load = new LoadPropertyFile();

	/**
	 * Method used to load the driver and redirect to the url present in the config
	 * file
	 * 
	 * @param configFilePath
	 */
	@SuppressWarnings("deprecation")
	@BeforeTest
//	@Parameters("selectBrowser")
	public void intitailizeBrowser() throws IOException {
		BasicConfigurator.configure();
		baseClass = ReadPropertiesFile.loadProperty(FilePath.CONFIG_FILE);
		url = baseClass.getProperty("URL");
		nodeUrl = baseClass.getProperty("nodeUrl");

		// Type of connection is taken from the config file
		connecton = baseClass.getProperty("CONNECTION");

		 browser = baseClass.getProperty("browser");

		// flow of the driver to be GRID or Normal in the base class
		if (connecton.equalsIgnoreCase("normal")) {

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FilePath.CHROME_PATH);

				driver = new ChromeDriver();
				driver.get(url);

			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FilePath.FIREFOX_PATH);
				driver = new FirefoxDriver();
				driver.get(url);
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.edge.driver", FilePath.IE_PATH);
				DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
				driver = new InternetExplorerDriver(ieCaps);
			} else {
				System.out.println("Driver not found in the config file");
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		}
		// if connection is to be grid
		if (connecton.equalsIgnoreCase("Grid"))

		{
			System.out.println("Grid connection");
			GridConnection grid = new GridConnection();
			ExtentReport.driver = grid.getConnection(driver, browser, url, nodeUrl);
		}
	}
}