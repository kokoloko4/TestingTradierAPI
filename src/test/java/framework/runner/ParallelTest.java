package framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

public class ParallelTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object [][] scenarios () {
        return super.scenarios();
    }
}
