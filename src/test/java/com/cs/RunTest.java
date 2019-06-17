package com.cs;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"target/Reports"},
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        tags = {}
)

public class RunTest {

}
