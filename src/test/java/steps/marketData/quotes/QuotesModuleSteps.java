package steps.marketData.quotes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.marketDataEntities.quotes.Quote;
import helpers.QuotesHelper;
import utils.Share;
import utils.dataGenerator.QuoteGenerator;

public class QuotesModuleSteps {

    @Given("^I have a quote$")
    public void iHaveAQuote(){
        Quote quote = QuoteGenerator.generateQuote();
        Share.setShare("quote", quote);
    }

    @When("^I send a get request with the symbol \"([^\"]*)\" to the API$")
    public void iSendAGetRequestWithTheSymbolsToTheAPI(String symbol){
        Share.setShare("quotes", QuotesHelper.getQuotes("GET", symbol));
    }

    @When("I send a post request with the symbol \"([^\"]*)\" to the API$")
    public void ISendAPostRequestWithTheSymbolsToTheAPI(String symbol){
        Share.setShare("quotes", QuotesHelper.postQuotes("POST", symbol));
    }
}
