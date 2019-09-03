package steps.marketData.timesales;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.TimeSalesHelper;
import utils.Share;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSalesModuleSteps {

    @Given("^I have a time and sales of \"([^\"]*)\"$")
    public void iHaveTimeSales(String symbol){
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Share.setShare("timeSales", formatDate.format(new Date()));
    }

    @When("^I send a request to timesales module with the symbol \"([^\"]*)\"$")
    public void iSendARequestToTimesalesModuleWithTheSymbol(String symbol){
        Share.setShare("seriesResponse", TimeSalesHelper.getTimeSales("GET", symbol));
    }
}
