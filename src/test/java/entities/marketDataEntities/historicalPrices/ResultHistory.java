package entities.marketDataEntities.historicalPrices;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class ResultHistory {

    @JsonProperty("history")
    @Getter
    private History dates;
}
