package steps.marketData.quotes;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.quotes.Quote;
import entities.marketDataEntities.quotes.Quotes;
import helpers.QuotesHelper;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class QuotesAssertionsSteps {

    @Then("^I get the quotes related to the symbols$")
    public void iGetTheQuotesRelatedToTheSymbols(){
        Quotes quotes = Share.getShare("quote");
        Quotes quoteResponse = Share.getShare("quotes");
        assertThat("The quotes do not contain the symbols expected",
                QuotesHelper.responseContainsSymbols(quotes, quoteResponse));
    }
}
