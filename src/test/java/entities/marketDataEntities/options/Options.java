package entities.marketDataEntities.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.marketDataEntities.quotes.Quote;
import lombok.Getter;

import java.util.List;

public class Options {

    @JsonProperty("option")
    @Getter
    private List<Quote> options;
}
