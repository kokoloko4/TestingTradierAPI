package steps.marketData.quotes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.marketDataEntities.quotes.Quotes;
import helpers.QuotesHelper;
import utils.Share;
import utils.dataGenerator.QuoteGenerator;

public class QuotesModuleSteps {

    @Given("^I have a quotes with symbols \"([^\"]*)\"$")
    public void iHaveAQuote(String symbols){
        Quotes quotes = QuoteGenerator.generateQuotes(symbols);
        Share.setShare("quote", quotes);
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
