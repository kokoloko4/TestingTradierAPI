package steps.marketData.historicalQuotes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.HistoricalPricesHelper;
import utils.Share;
import utils.dataGenerator.MonthlyDatesGenerator;

public class HistoricalModuleSteps {

    @Given("^I have a list of dates monthly of \"([^\"]*)\"$")
    public void iHaveListDatesMonthly(String symbol){
        String[] dates = MonthlyDatesGenerator.getDates();
        Share.setShare("dates", dates);
    }

    @When("^I send a request to historical module with the symbol \"([^\"]*)\" monthly$")
    public void iSendARequestToHistoricalModuleWithTheSymbol(String symbol){
        Share.setShare("days", HistoricalPricesHelper.getHistoricalPrices("GET", symbol, "monthly"));
    }
}
