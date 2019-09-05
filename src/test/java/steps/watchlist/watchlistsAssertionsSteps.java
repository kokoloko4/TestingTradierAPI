package steps.watchlist;

import cucumber.api.java.en.Then;
import entities.watchlistEntities.Watchlist;
import entities.watchlistEntities.Watchlists;
import helpers.WatchlistsHelper;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class watchlistsAssertionsSteps {

    @Then("^I get the users watchlists information$")
    public void iGetTheUsersWatchlistInformation(){
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlists watchlists = Share.getShare("watchlists");
        assertThat("The watchlists is not in the api watchlists", WatchlistsHelper.validateWatchlist(watchlist, watchlists));
    }

    @Then("^I get the information of the specific watchlist$")
    public void iGetTheInformationOfTheSpecificWatchlist(){
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist responseWatchlist = Share.getShare("watchlistResponse");
        assertThat("The watchlist created is not the same", WatchlistsHelper.validateSpecWatchlist(watchlist, responseWatchlist));
    }

    @Then("^I get the watchlist the watchlist with the name and symbols sent$")
    public void iGetTheWatchlist(){
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist newWatchlist = Share.getShare("newWatchlist");
        assertThat("The created watchlist is different", WatchlistsHelper.validateNewWatclist(watchlist, newWatchlist));
    }

    @Then("^I get the watchlist with the updated information")
    public void iGetTheWacthlistWithTheUpdatedInformation(){
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist newWatchlist = Share.getShare("updatedWatchlist");
        assertThat("The updated watchlist is different", WatchlistsHelper.validateNewWatclist(watchlist, newWatchlist));
    }

    @Then("^I get the deleted watchlist with related information")
    public void iGetTheDeletedWatchlistWithRelatedInformation(){
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist delWatchlist = Share.getShare("deletedWatchlist");
        assertThat("The deleted watchlist is different", WatchlistsHelper.validateNewWatclist(watchlist, delWatchlist));
    }

    @Then("^I get the watchlist with the added symbols")
    public void iGetTheWatchlistWithTheAddedSymbols(){
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist newWatchlist = Share.getShare("deletedWatchlist");
        assertThat("The symbols were not added", WatchlistsHelper.validateNewSymbols(watchlist, newWatchlist));
    }

    @Then("^I get the watchlist with the deleted symbol")
    public void iGetTheWatchlistWithTheDeletedSymbol(){
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist newWatchlist = Share.getShare("deleteSymbol");
        assertThat("The symbols were not deleted", WatchlistsHelper.validateDelSymbol(watchlist, newWatchlist));
    }
}
