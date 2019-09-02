package steps.marketData.quotes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.marketDataEntities.quotes.Quote;
import helpers.QuotesHelper;
import utils.Share;
import utils.dataGenerator.QuoteGenerator;

public class QuotesModuleSteps {

    @Given("^I have a quote with symbol \"([^\"]*)\"$")
    public void iHaveAQuote(String symbol){
        Quote quote = QuoteGenerator.generateQuote(symbol);
        Share.setShare("quote", quote);
    }

    @When("^I send a get request with the symbol \"([^\"]*)\" to the API$")
    public void iSendAGetRequestWithTheSymbolsToTheAPI(String symbol){
        Share.setShare("quotes", QuotesHelper.getQuotes("GET", symbol));
    }

    @When("^I send a post request with the symbol \"([^\"]*)\" to the API$")
    public void iSendAPostRequestWithTheSymbolsToTheAPI(String symbol){
        Share.setShare("quotes", QuotesHelper.postQuotes("POST", symbol));
    }
}
