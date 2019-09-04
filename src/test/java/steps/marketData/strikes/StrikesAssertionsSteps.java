package steps.marketData.strikes;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.strikes.Strike;
import entities.marketDataEntities.strikes.Strikes;
import helpers.StrikesHelper;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class StrikesAssertionsSteps {

    @Then("^I get the strike prices with the related symbol and expiration date$")
    public void iGetTheStrikePricesWithTheRelatedSymbolAndExpirationsDate(){
        assertThat("The strikes are not equal", StrikesHelper.verifyStrikes(Share.getShare("strikes"),
                ((Strike)Share.getShare("responseStrikes")).getStrikes()));
    }
}
