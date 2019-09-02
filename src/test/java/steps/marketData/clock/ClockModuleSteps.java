package steps.marketData.clock;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.ClockHelper;
import utils.Share;

public class ClockModuleSteps {

    @Given("^I have the hour when the market opens$")
    public void iHaveHourWhenMarketOpens(){
        Share.setShare("opens", "Market is open from 09:30 to 16:00");
    }

    @When("^I send a request to clock module the API$")
    public void iSendARequestToClockModuleTheAPI(){
        Share.setShare("clock", ClockHelper.getClock("GET"));
    }
}
