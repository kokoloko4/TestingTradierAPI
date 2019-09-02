package steps.marketData.timesales;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.marketDataEntities.timesales.TimeSales;
import helpers.TimeSalesHelper;
import utils.Share;
import utils.dataGenerator.TimeSalesGenerator;

public class TimeSalesModuleSteps {

    @Given("^I have a time and sales of \"([^\"]*)\"$")
    public void iHaveTimeSales(String symbol){
        TimeSales timeSales = TimeSalesGenerator.getTimeSales("2019-08-30T16:02:00");
        Share.setShare("timeSales", timeSales);
    }

    @When("^I send a request to timesales module with the symbol \"([^\"]*)\"$")
    public void iSendARequestToTimesalesModuleWithTheSymbol(String symbol){
        Share.setShare("seriesResponse", TimeSalesHelper.getTimeSales("GET", symbol));
    }
}
