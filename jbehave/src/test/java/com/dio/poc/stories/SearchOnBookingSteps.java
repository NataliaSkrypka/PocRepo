package com.dio.poc.stories;

import com.dio.poc.pages.HomePage;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by vanish on 2/19/14.
 */
public class SearchOnBookingSteps extends Steps {

    private static Logger LOG = LoggerFactory.getLogger(SearchOnBookingSteps.class);

    HomePage homePage;
    WebDriver driver;
    
    @BeforeScenario
    public void beforeScenario(){
    	driver = new FirefoxDriver();
    }

    @Given("user open main page")
    public void userOpenBookingComMainPage() {
        driver.get("http://www.booking.com/");
        homePage = new HomePage(driver);
    }

    @When("user performs search for <fullText> on main page")
    public void searchTextOnBookingCom(@Named("fullText") final String searchString) {
        homePage.inputTextInSearchField(searchString);
        homePage.clickOnNoSpecificDatesCheckBox();
        homePage.clickOnSearchButton();
    }

    @When("user leave search fields empty")
    public void leaveSearchFieldsEmpty() {
    	searchTextOnBookingCom("");
    }

    @When("user performs search for <fullText> on main page and leave dates not specified")
    public void enterSomeTextAndLeaveDatesEmpty(@Named("fullText") final String searchString){
        homePage.inputTextInSearchField(searchString);
        homePage.clickOnSearchButton();
    }

    @Then("mentioned entity is shown in the result")
    public void searchResultsOnBookingCom() {
        List<String> results = homePage.getListOfCitiesAfterSearch();
        for (String row : results) {
            LOG.info("Location in list: " + row);
        }
    }

    @Then("result list is empty")
    public void isSearchResultEmpty() {
        Assert.assertTrue("Search result is not empty", 0 == (homePage.getSearchResultList().size()));
    }

    @Then("message <message> is shown on search result")
    public void checkMessageOnSearchResult(@Named("message") final String messageOnSearchResults) {
        Assert.assertEquals("Message is not as expected", messageOnSearchResults, homePage.getErrorMessage());
    }

    @Then("error message <message> about invalid dates is shown on search result")
    public void checkMessageOnDates(@Named("message") final String messageOnDates){
        Assert.assertEquals("Message is not as expected", messageOnDates, homePage.getErrorOnDates());
    }
    
    @AfterScenario
    public void afterScenario(){
    	if(driver != null){
    		driver.quit();
    	}
    }

}
