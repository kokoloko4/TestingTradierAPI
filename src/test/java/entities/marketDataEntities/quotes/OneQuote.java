package entities.marketDataEntities.quotes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class OneQuote {

    @Getter
    @JsonProperty("quote")
    private Quote quotes;
}
