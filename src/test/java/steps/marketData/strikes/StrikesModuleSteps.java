package steps.marketData.strikes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.StrikesHelper;
import utils.Share;
import utils.dataGenerator.StrikesGenerator;

public class StrikesModuleSteps {

    @Given("^I have a list of strikes of \"([^\"]*)\" at \"([^\"]*)\"$")
    public void iHaveListOfStrikes(String symbol, String date){
        Double[] strikes = StrikesGenerator.getStrikes();
        Share.setShare("strikes", strikes);
    }

    @When("^I send a request to strikes module with the symbol \"([^\"]*)\" and the expiration date \"([^\"]*)\"$")
    public void iSendARequestToStrikesModuleWithTheSymbolAndTheExpirationDate(String symbol, String date){
        Share.setShare("responseStrikes", StrikesHelper.getStrikes("GET", symbol, date));
    }
}
