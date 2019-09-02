package entities.marketDataEntities.quotes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultQuotes {

    @JsonProperty("quotes")
    private OneQuote quotes;

    public OneQuote getQuotes() {
        return quotes;
    }

    public void setQuotes(OneQuote quotes) {
        this.quotes = quotes;
    }
}
