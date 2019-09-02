package steps.marketData.strikes;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.strikes.Strike;
import helpers.StrikesHelper;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class StrikesAssertionsSteps {

    @Then("^I get the strike prices with the related symbol and expiration date$")
    public void iGetTheStrikePricesWithTheRelatedSymbolAndExpirationsDate(){
        Double[] strikes = Share.getShare("strikes");
        Strike responseStrikes = Share.getShare("responseStrikes");
        assertThat("The strikes are not equal", StrikesHelper.verifyStrikes(strikes, responseStrikes.getStrikes()));
    }
}
