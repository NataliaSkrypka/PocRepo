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

    @Given("^aaa$")
    public void aaa() {
        LOG.error("aaa");
    }

    @When("^bbb$")
    public void bbb() {
        LOG.error("bbb");
    }

    @Then("^ccc$")
    public void ccc() {
        LOG.error("ccc");
    }

    @Then("^eee$")
    public void eee() {
        LOG.error("eee");
    }

    @Then("^ddd$")
    public void ddd() {
        LOG.error("ddd");
    }

    @Given("^aaa (.*)$")
    public void aaa_aa_t(String mm){
        LOG.error("aaa " + mm);
    }
}
