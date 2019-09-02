package steps.marketData.chain;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.marketDataEntities.quotes.Quote;
import helpers.OptionsHelper;
import utils.Share;
import utils.dataGenerator.QuoteGenerator;

public class ChainModuleSteps {

    @Given("^I have a list of options chains of symbol \"([^\"]*)\" and expiration date \"([^\"]*)\"$")
    public void iHaveAListOptionsChains(String symbol, String date){
        Quote option = QuoteGenerator.generateOption(symbol, date);
        Share.setShare("option", option);
    }

    @When("^I send a request to chain module with the symbol \"([^\"]*)\" and the expiration date \"([^\"]*)\"")
    public void iSendARequestToChainModuleWithTheSymbolAndTheExpirationDate(String symbol, String date){
        Share.setShare("options", OptionsHelper.getOptions("GET", symbol, date));
    }

}
