package com.dio.poc.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by vanish on 2/19/14.
 */
public class AbstractPage {

        protected final WebDriver driver;

        protected AbstractPage(WebDriver driver) {
            this.driver = driver;
        }


}
