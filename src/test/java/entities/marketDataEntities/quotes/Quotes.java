package entities.marketDataEntities.quotes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Quotes {

    @JsonProperty("quote")
    @Getter @Setter
    private List<Quote> quotes;
}
