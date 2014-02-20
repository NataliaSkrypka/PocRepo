package com.dio.poc.stories;

import java.util.List;

import org.fluentlenium.adapter.FluentTest;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dio.poc.pages.HomeWithFluentPage;

public class SearchOnBookingWithFluentSteps extends FluentTest {

	private static Logger LOG = LoggerFactory.getLogger(SearchOnBookingWithFluentSteps.class);

	HomeWithFluentPage homePage;
    WebDriver driver;

    @BeforeScenario
    public void beforeScenario(){
    	driver = new FirefoxDriver();
    }

    @Given("f user open main page")
    public void userOpenBookingComMainPage() {
//        driver.get("http://www.booking.com/");
        homePage = new HomeWithFluentPage(driver);
        goTo(homePage);
    }

    @When("f user performs search for <fullText> on main page")
    public void searchTextOnBookingCom(@Named("fullText") final String searchString) {
        homePage.inputTextInSearchField(searchString);
        homePage.clickOnNoSpecificDatesCheckBox();
        homePage.clickOnSearchButton();
    }

    @When("f user leave search fields empty")
    public void leaveSearchFieldsEmpty() {
        homePage.inputTextInSearchField("");
        homePage.clickOnNoSpecificDatesCheckBox();
        homePage.clickOnSearchButton();
    }

    @When("f user performs search for <fullText> on main page and leave dates not specified")
    public void enterSomeTextAndLeaveDatesEmpty(@Named("fullText") final String searchString){
        homePage.inputTextInSearchField(searchString);
        homePage.clickOnSearchButton();
    }

    @Then("f mentioned entity is shown in the result")
    public void searchResultsOnBookingCom() {
        List<String> results = homePage.getListOfCitiesAfterSearch();
        for (String row : results) {
            LOG.info("Location in list: " + row);
        }
    }

    @Then("f result list is empty")
    public void isSearchResultEmpty() {
        Assert.assertTrue("Search result is not empty", 0 == (homePage.getSearchResultList().size()));
    }

    @Then("f message <message> is shown on search result")
    public void checkMessageOnSearchResult(@Named("message") final String messageOnSearchResults) {
        Assert.assertEquals("Message is not as expected", messageOnSearchResults, homePage.getErrorMessage());
    }

    @Then("f error message <message> about invalid dates is shown on search result")
    public void checkMessageOnDates(@Named("message") final String messageOnDates){
        Assert.assertEquals("Message is not as expected", messageOnDates, homePage.getErrorOnDates());
    }

    @AfterScenario
    public void afterStories(){
        driver.quit();
    }
}
