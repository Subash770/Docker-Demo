package com.example.docker.runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/UserAPI.feature",  // Path to your feature file
        glue = "com.example.docker.stepdefinitions", // Path to your step definitions
        plugin = {"pretty"
                ,"html:target/cucumber-reports/UserAPI.html"
                ,"json:target/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
