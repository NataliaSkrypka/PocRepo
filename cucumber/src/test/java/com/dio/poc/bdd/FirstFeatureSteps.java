package com.dio.poc.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by vanish on 2/19/14.
 */
public class FirstFeatureSteps {

    private static final Logger LOG = LoggerFactory.getLogger(FirstFeatureSteps.class);

    @Given("^user open main page$")
    public void userOpenMainPage() {
        LOG.error("user open main page");
    }

    @When("^user performs search for (.+) on main page$")
    public void userPerformsSearch(String searchText) {
        LOG.error("user performs search for on main page");
    }
    
    @When("^user leave search fields empty$")
    public void userLeaveSearchFieldEmpty(){
    	LOG.info("user leave search fields empty");
    }
    
    @When("^user performs search for (.+) on main page and leave dates not specified$")
    public void userSearchWithoutSpecifiedDates(String searchText){
    	LOG.info("user performs search for on main page and leave dates not specified");
    }

    @Then("^mentioned entity is shown in the result$")
    public void resultIsShown() {
        LOG.error("mentioned entity is shown in the result");
    }

    @Then("^message (.+) is shown on search result$")
    public void messageIsShownOnResult(String expectedMessage) {
        LOG.error("message is shown on search result");
    }

    @Then("^error message (.+) about invalid dates is shown on search result$")
    public void errorMessageOnDatesIsShown(String expectedMessage) {
        LOG.error("error message about invalid dates is shown on search result");
    }

}
