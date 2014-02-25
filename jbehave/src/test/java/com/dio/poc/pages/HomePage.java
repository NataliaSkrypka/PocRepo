package com.dio.poc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanish on 2/19/14.
 */
public class HomePage extends AbstractPage {

	private static final String SEARCH_FIELD = "//input[@id='destination']";
	private static final String AUTOCOMPLETE_LIST = "//ul[contains(@class, 'ui-autocomplete')]";
	private static final String SERCH_CITY_TEMPLATE = "//div[@id='cityWrapper']/div[%d]/div[2]/a";
	private static final String ERROR_ON_SEARCH = "//div[@id='b_searchbox_errors']/p";
	private static final String CHECKBOX_NO_SPECIFIC_DATES = "//input[@id='availcheck']";
	private static final String SEARCH_BUTTON = "//button[@id='searchbox_btn']";
	private static final String ERROR_ON_DATES = "//p[contains(@class,'dateerros')]";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void inputTextInSearchField(String searchText) {
		driver.findElement(By.xpath(SEARCH_FIELD)).clear();
		driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(searchText);
	}

	public List<String> getSearchResultList() {
		List<String> searchResult = new ArrayList<String>();
		List<WebElement> searchElements = driver.findElements(By
				.xpath(AUTOCOMPLETE_LIST));

		for (WebElement element : searchElements) {
			searchResult.add(element.getText());
		}

		return searchResult;
	}

	public String getErrorMessage() {
		return driver.findElement(By.xpath(ERROR_ON_SEARCH)).getText();
	}

	public void clickOnNoSpecificDatesCheckBox() {
		driver.findElement(By.xpath(CHECKBOX_NO_SPECIFIC_DATES)).click();
	}

	public void clickOnSearchButton() {
		driver.findElement(By.xpath(SEARCH_BUTTON)).click();
	}

	public List<String> getListOfCitiesAfterSearch() {
		List<String> cityList = new ArrayList<String>();
		for (int i = 1; i <= 5; i++) {
			cityList.add(driver.findElement(
					By.xpath(String.format(SERCH_CITY_TEMPLATE, i))).getText());
		}
		return cityList;
	}

	public String getErrorOnDates() {
		return driver.findElement(By.xpath(ERROR_ON_DATES)).getText();
	}

	public void enterTextAndClickSearch(String textToSearch) {
		inputTextInSearchField(textToSearch);
		clickOnNoSpecificDatesCheckBox();
		clickOnNoSpecificDatesCheckBox();
	}

}
