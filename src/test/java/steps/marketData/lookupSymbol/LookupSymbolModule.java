package steps.marketData.lookupSymbol;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.SymbolHelper;
import utils.Share;

public class LookupSymbolModule {

    @Given("^I want the companies that have the symbol \"([^\"]*)\"$")
    public void iWantCompaniesWithSymbol(String symbol){
        Share.setShare("symbol", symbol);
    }

    @When("I send a request with the symbol \"([^\"]*)\" as query$")
    public void iSendARequestWithTheSymbolAsQuery(String symbol){
        Share.setShare("securities", SymbolHelper.getCompanies("GET", symbol));
    }
}
