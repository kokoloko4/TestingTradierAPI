package steps.marketData.quotes;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.quotes.Quote;
import entities.marketDataEntities.quotes.OneQuote;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class QuotesAssertionsSteps {

    @Then("I get the quotes related to the symbols")
    public void IGetTheQuotesRelatedToTheSymbols(){
        Quote quote = Share.getShare("quote");
        OneQuote quoteResponse = Share.getShare("quotes");
        assertThat(quote.getSymbol(), equalTo(quoteResponse.getQuotes().getSymbol()));
    }
}
