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
        String timeSales = Share.getShare("timeSales");
        Data data = Share.getShare("seriesResponse");
        assertThat("The timesales are not from today",
                TimeSalesHelper.verifyTimeIsActualDay(timeSales, data));
    }
}
