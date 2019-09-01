package entities.marketDataEntities.quotes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public class Quotes {

    @Getter
    @JsonProperty("quote")
    private List<Quote> quotes;
}
