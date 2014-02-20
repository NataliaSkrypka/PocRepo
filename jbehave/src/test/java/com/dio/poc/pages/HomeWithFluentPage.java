package com.dio.poc.pages;

import java.util.ArrayList;
import java.util.List;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class HomeWithFluentPage extends FluentPage {
	
	public HomeWithFluentPage(){
		super();
	}
	
	public HomeWithFluentPage (WebDriver driver){
		super(driver);
	}
	
	@Override
	public String getUrl(){
		return "http://www.booking.com/";
	}

	@Override
	public void isAt() {
		Assert.assertTrue(title().contains("Booking.com"));
	}

	public void inputTextInSearchField(String searchString) {
		clear("#destination");
		fill("#destination").with(searchString);
	}

	public void clickOnNoSpecificDatesCheckBox() {
		click("#availcheck");
	}

	public void clickOnSearchButton() {
		click("#searchbox_btn");
	}

	public List<String> getListOfCitiesAfterSearch() {
		List<String> cityList = new ArrayList<String>();
		int numOfCities = 5;
		for (int i = 1; i < numOfCities ; i++){
			cityList.add(find("#cityWrapper div .disname .destination_name", i).getText());
		}
		return cityList;
	}

	public List<String> getSearchResultList() {
		List<String> searchResult = new ArrayList<String>();
		searchResult = find(".ui-autocomplete").getTexts();
		return searchResult;
	}

	public String getErrorMessage() {
		return find("[class=error]").getText();
	}

	public String getErrorOnDates() {
		return find(".error.errors_dateerros").getText();
	}
	
	

}
