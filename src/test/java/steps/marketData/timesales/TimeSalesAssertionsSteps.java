package steps.marketData.timesales;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.timesales.Data;
import entities.marketDataEntities.timesales.TimeSales;
import helpers.TimeSalesHelper;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class TimeSalesAssertionsSteps {

    @Then("^I get a list of timesales information$")
    public void iGetAListOfTimesalesInformation(){
        assertThat("The timesales are not from today",
                TimeSalesHelper.verifyTimeIsActualDay(
                        Share.getShare("timeSales"), Share.getShare("seriesResponse")));
    }
}
