package entities.marketDataEntities.historicalPrices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultHistory {

    @JsonProperty("history")
    private History dates;

    public History getDates() {
        return dates;
    }
}
