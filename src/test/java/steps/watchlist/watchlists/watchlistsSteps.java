package steps.watchlist.watchlists;

import cucumber.api.java.en.When;

public class watchlistsSteps {

    @When("I send a request to the API$")
    public void ISendARequestToTheAPI(){

    }

    @When("I send a request with the watchlist id \"([^\"]*)\" to the API$")
    public void ISendARequestWithTheWatchlistIdToTheAPI(String id){

    }

    @When("I send a request with the name \"([^\"]*)\" and symbols \"([^\"]*)\" of the new watchlist$")
    public void ISendARequestWithTheNameAndSymbolsOfTheNewWatchlist(String name, String symbols){

    }

    @When("I send a request with the watchlist id \"([^\"]*)\" and the updated name \"([^\"]*)\"$")
    public void ISenARequestWithTheWatchlistIdAndTheUpdatedName(String id, String name){

    }

    @When("I send a request with watchlist id \"([^\"]*)\" to the API")
    public void ISendARequestWithWatchlistIdToTheAPI(String id){

    }

    @When("I send a request with watchlist id \"([^\"]*)\" and the symbols \"([^\"]*)\"")
    public void ISendARequestWithWatchlistIdAnTheSymbols(String id, String symbols){

    }

    @When("I send a request with the watchlist id \"([^\"]*)\" and the symbol \"([^\"]*)\"")
    public void ISendARequestWithTheWatchlistIdAndTheSymbol(String id, String symbol){

    }
}
