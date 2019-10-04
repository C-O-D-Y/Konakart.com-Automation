package com.atmecs.helpers;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.constants.FilePath;
import com.atmecs.testBase.TestBase;

/**
 * Class contains methods of different functionalities used in web testing
 */
public class WebUtility extends TestBase {

	/**
	 * method click the Element using the fluent wait concepts ignoring the
	 * ElementClickInterceptedException.
	 * 
	 * @param driver
	 * @param xpath
	 */
	static Actions action = new Actions(driver);

	public static void clickElement(final String xpath) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
				.withTimeout(Duration.ofSeconds(30));

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.click();

				return true;
			}
		});
	}

	/**
	 * method select the dropdown and select the Element by visible text, using the
	 * fluent wait concepts ignoring the ElementClickInterceptedException.
	 * 
	 * @param driver
	 * @param xpath
	 */
	public static void selectDropdown(final String xpath, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				Select trip = new Select(element);

				trip.selectByVisibleText(text);
				return true;
			}

		});
	}

	/**
	 * method click the blank fields and send the text to be entered
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @param text
	 */
	public static void clickAndSendText(final String xpath, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
				.withTimeout(Duration.ofSeconds(30));

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.sendKeys(text);
				;
				return true;
			}
		});
	}

	public static String getText(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		String text = element.getText();
		return text;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param XPathIsDisplayed
	 * @return element on the web page
	 */
	public static WebElement getElement(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param XPathIsDisplayed
	 * @return a boolean value for the displayed element on the web page
	 */
	public static boolean isDisplayed(String XPathIsDisplayed) {
		boolean isDisplayed = false;
		try {
			isDisplayed = driver.findElement(By.xpath(XPathIsDisplayed)).isDisplayed();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param XPathIsSelected
	 * @return a boolean value for the selected element on the web page
	 */
	public static boolean isSelected(String XPathIsSelected) {
		boolean isSelected = false;
		try {
			isSelected = driver.findElement(By.xpath(XPathIsSelected)).isSelected();
		} catch (Exception e) {
			isSelected = false;
		}
		return isSelected;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param xpath and uses the explicit wait concept
	 * @return a boolean value after checking the visibility of the.
	 */
	public static boolean isElementVisible(String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {

			return false;
		}
		return true;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param xpath
	 * @return the list of elements
	 */

	public static List<WebElement> getElementsList(final String xpath) {

		List<WebElement> element = driver.findElements(By.xpath(xpath));
		return element;
	}

	/**
	 * method scroll down the window on the web page
	 * 
	 * @param horizontal index
	 * @param vertical   index
	 */

	public static void scrollDownPage(int horizontalIndex, int verticalIndex) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scroll = "window.scrollBy(" + horizontalIndex + "," + verticalIndex + ")";
		js.executeScript(scroll);
	}

	/**
	 * In this method, mouse over operation of the mouse is done
	 * 
	 * @param xpath
	 */
	public static void action(String xpath) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("System interrupted");
		}

		WebElement element = driver.findElement(By.xpath(xpath));
		action.moveToElement(element).build().perform();
	}

	/**
	 * In this method,Input boxes entered texts are cleared
	 * 
	 * @param xpath
	 */
	public static void clearField(String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
	}

	/**
	 * Method gets the title of the current page
	 */
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * Method waits for the time until the xpath of the element is clickable
	 * 
	 * @param xpath
	 */
	public static void explicitWait(String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, FilePath.TIMEOUT_INSECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	/**
	 * Method scrolls down the window resolution until the view of webelement is not
	 * found
	 * 
	 * @param xpath
	 */
	public static void scrollIntoview(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Method gets the attribute of the web element
	 * 
	 * @param xpath
	 */
	public static String getAttribute(String xpath, String attribute) {
		WebElement element = driver.findElement(By.xpath(xpath));
		String value = element.getAttribute(attribute);
		return value;

	}

	/**
	 * Method gets the attribute of the web element
	 * 
	 * @param xpath
	 */
	public static void scrollByTimeout(final String xpath) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(3))
				.withTimeout(Duration.ofSeconds(90));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				action.sendKeys(Keys.SPACE);
				scrollDownPage(0, -300);
				WebElement element = driver.findElement(By.xpath(xpath));
				element.click();
				return true;
			}

		});
	}

	/**
	 * method select the dropdown and select the Element by index, using the fluent
	 * wait concepts ignoring the ElementClickInterceptedException.
	 * 
	 * @param driver
	 * @param xpath
	 */
	public static void selectDropdownByIndex(String xpath, int index) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				Select trip = new Select(element);

				trip.selectByIndex(index);
				return true;
			}

		});
	}
}