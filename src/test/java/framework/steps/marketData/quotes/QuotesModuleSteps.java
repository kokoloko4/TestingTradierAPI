package framework.steps.marketData.quotes;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.When;
import framework.entities.marketDataEntities.Quotes;
import framework.helpers.QuotesHelper;
import framework.utils.Share;
import io.restassured.response.Response;

import java.io.IOException;

public class QuotesModuleSteps {

    @When("^I send a get request with the symbols \"([^\"]*)\" to the API$")
    public void ISendAGetRequestWithTheSymbolsToTheAPI(String symbols) throws IOException {
        QuotesHelper quotesHelper = new QuotesHelper();
        Response response = quotesHelper.getQuotes(symbols);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(response.jsonPath().getString("quotes"));

        Quotes quotes = mapper.readValue(response.jsonPath().getString("quotes.quote"), Quotes.class);
        Share.setShare("quotesResponse", quotes);
    }


    @When("I send a post request with the symbols \"([^\"]*)\" to the API$")
    public void ISendAPostRequestWithTheSymbolsToTheAPI(String symbols){

    }
}
