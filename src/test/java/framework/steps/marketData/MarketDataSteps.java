package framework.steps.marketData;

import cucumber.api.java.en.Given;
import framework.entities.marketDataEntities.Quote;
import framework.utils.AccessToken;
import framework.utils.Share;
import framework.utils.dataGenerator.QuoteGenerator;

public class MarketDataSteps {

    @Given("I have an access token$")
    public void IHaveAndAccessToken(){
        AccessToken.getAccessToken();
        Quote quote = QuoteGenerator.generateQuote();
        Share.setShare("quote", quote);
    }
}
