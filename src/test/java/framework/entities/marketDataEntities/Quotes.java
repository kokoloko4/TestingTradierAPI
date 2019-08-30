package framework.entities.marketDataEntities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Quotes {

    @JsonProperty("quote")
    private List<Quote> quotes;
}
