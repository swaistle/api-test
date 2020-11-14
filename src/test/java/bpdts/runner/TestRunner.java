package bpdts.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber-reports/testrunner.json",
                "html:target/cucumber-reports/testrunner"
        },
        glue = {
                "bpdts.stepdefinitions"
        },
        features = {
                "src/test/resources"
        },
        monochrome = true
)

public class TestRunner {
}