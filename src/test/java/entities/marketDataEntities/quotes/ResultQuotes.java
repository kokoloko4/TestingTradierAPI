package entities.marketDataEntities.quotes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class ResultQuotes {

    @JsonProperty("quotes")
    @Getter @Setter
    private Quotes quotes;
}
