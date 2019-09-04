package steps.marketData.chain;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.options.Options;
import entities.marketDataEntities.quotes.Quote;
import helpers.OptionsHelper;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class ChainAssertionsSteps {

    @Then("^I get the options with the related symbol and expiration date$")
    public void iGetTheOptionsWithTheRelatedSymbolAndExpirationDate() {
        assertThat("There is a option that have not the symbol or expiration date",
                OptionsHelper.verifyOptions(Share.getShare("option"),
                        ((Options)Share.getShare("options")).getOptions()));
    }


}
