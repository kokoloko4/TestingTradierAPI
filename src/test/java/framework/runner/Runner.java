package framework.runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    glue = "framework.steps",
    plugin = {"pretty", "json:target/jsonReports/cucumber.json"},
    features = "src/test/resources/features"
)
public class Runner extends  ParallelTest{

}
