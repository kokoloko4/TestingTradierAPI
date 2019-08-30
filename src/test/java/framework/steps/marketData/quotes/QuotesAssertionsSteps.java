package framework.steps.marketData.quotes;

import cucumber.api.java.en.Then;
import framework.entities.marketDataEntities.Quote;
import framework.utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class QuotesAssertionsSteps {

    @Then("I get the quotes related to the symbols")
    public void IGetTheQuotesRelatedToTheSymbols(){
        Quote quote = Share.getShare("quote");
        Quote quoteResponse = Share.getShare("quotesResponse");
        assertThat("Quotes not found" ,quote.getSymbol(), equalTo(quoteResponse.getSymbol()));
    }
}
