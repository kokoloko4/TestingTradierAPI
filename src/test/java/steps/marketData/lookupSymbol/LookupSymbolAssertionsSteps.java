package steps.marketData.lookupSymbol;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.securities.Security;
import helpers.SymbolHelper;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class LookupSymbolAssertionsSteps {

    @Then("^I get a list with the securities that contains the symbol$")
    public void iGetAListWithTheSecuritiesThatContainsTheSymbol(){
        String word = Share.getShare("symbol");
        Security security = Share.getShare("securities");
        assertThat("There are one o many securities that does not contains the word",
                SymbolHelper.validateWord(word, security));
    }
}
