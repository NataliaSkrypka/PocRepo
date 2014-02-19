package com.dio.poc.bdd;

import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by vanish on 2/19/14.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(format = {
        "pretty",
        "html:target/cucumber-html-report"
},features = {"src/test/resources/features"})
public class PocCucumberStories {

    private static WebDriver webDriver;

    @BeforeClass
    public static void initWebDriver() {
        webDriver = new FirefoxDriver();
    }

    @AfterClass
    public static void shutdownWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
}
