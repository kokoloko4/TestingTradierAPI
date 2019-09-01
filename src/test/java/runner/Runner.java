package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    glue = "steps",
    plugin = {"pretty", "json:target/jsonReports/cucumber.json"},
    features = "src/test/resources/features"
)
public class Runner extends  ParallelTest{

}
