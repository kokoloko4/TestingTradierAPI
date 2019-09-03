package steps.marketData.historicalQuotes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.HistoricalPricesHelper;
import utils.Share;
import utils.dataGenerator.MonthlyDatesGenerator;

import java.util.List;

public class HistoricalModuleSteps {

    @Given("^I have a list of dates monthly of symbol$")
    public void iHaveListDatesMonthly(List<String> data){
        String[] dates = MonthlyDatesGenerator.getDates(data);
        Share.setShare("dates", dates);
    }

    @When("^I send a request to historical module with the symbol \"([^\"]*)\" monthly$")
    public void iSendARequestToHistoricalModuleWithTheSymbol(String symbol){
        Share.setShare("days", HistoricalPricesHelper.getHistoricalPrices("GET", symbol, "monthly"));
    }
}
