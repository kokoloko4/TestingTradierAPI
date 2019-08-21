package framework.steps.marketData.quotes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.When;
import framework.entities.marketDataEntities.Quote;
import framework.entities.marketDataEntities.Quotes;
import framework.helpers.QuotesHelper;
import framework.utils.Share;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class QuotesModuleSteps {

    @When("I send a get request with the symbols \"([^\"]*)\" to the API$")
    public void ISendAGetRequestWithTheSymbolsToTheAPI(String symbols) throws IOException {
        QuotesHelper quotesHelper = new QuotesHelper();
        Response response = quotesHelper.getQuotes(symbols);
        List<Quote> auxiliar = response.path("quotes.quote");
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Quote>> typeReference = new TypeReference<List<Quote>>() {};
        String quoteArray = mapper.writeValueAsString(auxiliar);
        List<Quote> quotes = mapper.readValue(quoteArray, typeReference);
        Share.setShare("quotesResponse", quotes);
    }

    @When("I send a post request with the symbols \"([^\"]*)\" to the API$")
    public void ISendAPostRequestWithTheSymbolsToTheAPI(String symbols){

    }
}
