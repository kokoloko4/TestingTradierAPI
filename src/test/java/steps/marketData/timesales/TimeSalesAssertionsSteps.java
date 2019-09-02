package steps.marketData.timesales;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.timesales.Data;
import entities.marketDataEntities.timesales.TimeSales;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class TimeSalesAssertionsSteps {

    @Then("^I get a list of timesales information$")
    public void IGetAListOfTimesalesInformation(){
        TimeSales timeSales = Share.getShare("timeSales");
        Data data = Share.getShare("seriesResponse");
        assertThat("Time of the list does not match", timeSales.getTime().equals(data.getTimesales().getTime()));
    }
}
