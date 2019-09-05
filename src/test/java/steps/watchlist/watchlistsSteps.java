package steps.watchlist;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.watchlistEntities.Watchlist;
import helpers.WatchlistsHelper;
import utils.Share;
import utils.dataGenerator.WatchlistGenerator;

public class watchlistsSteps {

    @Given("^I want to create a watchlist with the name \"([^\"]*)\" and symbols \"([^\"]*)\"$")
    public void createWatchlistwithSymbols(String name, String symbols){
        Watchlist watchlist = WatchlistGenerator.getWatchlist(name, symbols);
        Share.setShare("watchlist", watchlist);
    }

    @Given("^I have a watchlist saved in the api with the name \"([^\"]*)\" and symbols \"([^\"]*)\"$")
    public void iHaveWatchlistInTheAPI(String name, String symbols){
        createWatchlistwithSymbols(name, symbols);
    }

    @Given("^I want to change name of a watchlist to \"([^\"]*)\"$")
    public void createWathlistWithoutSymbols(String name){
        Watchlist watchlist = WatchlistGenerator.getWatchlist(name);
        Share.setShare("watchlist", watchlist);
    }

    @Given("^I want to delete the watchlist with the name \"([^\"]*)\"$")
    public void deleteWatchlist(String name){
        createWathlistWithoutSymbols(name);
    }

    @Given("^I want to add the symbol \"([^\"]*)\" to the watchlist with name \"([^\"]*)\"$")
    public void iWantAddSymbolsToWatchlist(String symbols, String name){
        createWatchlistwithSymbols(name, symbols);
    }

    @Given("^I want to remove the \"([^\"]*)\" from the watchlist with name \"([^\"]*)\"$")
    public void removeSymbol(String symbol, String name){
        createWatchlistwithSymbols(name, symbol);
    }

    @When("^I send a request to the API$")
    public void iSendARequestToTheAPI(){
        Share.setShare("watchlists", WatchlistsHelper.getWatchlists());
    }

    @When("^I send a request with the watchlist id \"([^\"]*)\" to the API$")
    public void iSendARequestWithTheWatchlistIdToTheAPI(String id){
        Share.setShare("watchlistResponse", WatchlistsHelper.getOneWatchlist(id));
    }

    @When("^I send a request with the name \"([^\"]*)\" and symbols \"([^\"]*)\" of the new watchlist$")
    public void iSendARequestWithTheNameAndSymbolsOfTheNewWatchlist(String name, String symbols){
        Share.setShare("newWatchlist", WatchlistsHelper.createWatchlist(name, symbols));
    }

    @When("I send a request with the watchlist id \"([^\"]*)\" and the updated name \"([^\"]*)\"$")
    public void iSenARequestWithTheWatchlistIdAndTheUpdatedName(String id, String name){
        Share.setShare("updatedWatchlist", WatchlistsHelper.updateWatchList(name, id));
    }

    @When("^I send a request with watchlist id \"([^\"]*)\" to the API$")
    public void iSendARequestWithWatchlistIdToTheAPI(String id){
        Share.setShare("deletedWatchlist", WatchlistsHelper.deleteWatchList(id));
    }

    @When("^I send a request with watchlist id \"([^\"]*)\" and the symbols \"([^\"]*)\"$")
    public void iSendARequestWithWatchlistIdAnTheSymbols(String id, String symbols){
        Share.setShare("addSymbolsWatlist", WatchlistsHelper.addSymbols(id, symbols));
    }

    @When("^I send a request with the watchlist id \"([^\"]*)\" and the symbol \"([^\"]*)\"$")
    public void iSendARequestWithTheWatchlistIdAndTheSymbol(String id, String symbol){
        Share.setShare("deleteSymbol", WatchlistsHelper.deleteSymbolWatchList(id, symbol));
    }
}
