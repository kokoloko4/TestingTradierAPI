package steps.marketData.historicalQuotes;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.historicalPrices.History;
import helpers.HistoricalPricesHelper;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class HistoricalAssertionsSteps {

    @Then("^I get a list with the history related to the company$")
    public void iGetListWithTheHistoryRelatesdToTheCompany(){
        assertThat("The dates does not match", HistoricalPricesHelper.validateDates(Share.getShare("dates"),
                ((History)Share.getShare("days")).getDays()));
    }
}
