package com.dio.poc.bdd;

import java.util.List;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dio.poc.pages.HomePage;

/**
 * Created by vanish on 2/19/14.
 */
public class FirstFeatureSteps {

    private static final Logger LOG = LoggerFactory.getLogger(FirstFeatureSteps.class);
    WebDriver driver;
    HomePage homePage;

    @Given("^user open main page$")
    public void userOpenMainPage() {
        LOG.info("user open main page");
        driver = PocCucumberStories.getWebDriver();
        driver.get("http://www.booking.com/");
        homePage = new HomePage(driver);
    }

    @When("^user performs search for (.+) on main page$")
    public void userPerformsSearch(String searchText) {
        LOG.info("user performs search for on main page");
        homePage.inputTextInSearchField(searchText);
        homePage.clickOnNoSpecificDatesCheckBox();
        homePage.clickOnSearchButton();
    }
    
    @When("^user leave search fields empty$")
    public void userLeaveSearchFieldEmpty(){
    	LOG.info("user leave search fields empty");
    	userPerformsSearch("");
    }
    
    @When("^user performs search for (.+) on main page and leave dates not specified$")
    public void userSearchWithoutSpecifiedDates(String searchText){
    	LOG.info("user performs search for on main page and leave dates not specified");
    	homePage.inputTextInSearchField(searchText);
    	homePage.clickOnSearchButton();
    }

    @Then("^mentioned entity is shown in the result$")
    public void resultIsShown() {
        LOG.info("mentioned entity is shown in the result");
        List<String> results = homePage.getListOfCitiesAfterSearch();
        
        for(String city : results){
        	LOG.info("City in result: " + city);
        }
    }

    @Then("^message (.+) is shown on search result$")
    public void messageIsShownOnResult(String expectedMessage) {
        LOG.info("message is shown on search result");
        String actualErrorMessage = homePage.getErrorMessage();
		LOG.info("Actual error message: " + actualErrorMessage);
		Assert.assertEquals("Message is not as expected", expectedMessage, actualErrorMessage);
    }

    @Then("^error message (.+) about invalid dates is shown on search result$")
    public void errorMessageOnDatesIsShown(String expectedMessage) {
        LOG.info("error message about invalid dates is shown on search result");
        String actualErrorMessage = homePage.getErrorOnDates();
        LOG.info("Actual error message on dates" + actualErrorMessage);
        Assert.assertEquals("Message is not as expected", expectedMessage, actualErrorMessage);
    }

}
