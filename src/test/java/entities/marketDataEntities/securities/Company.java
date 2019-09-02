package entities.marketDataEntities.securities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("exchange")
    private String exchange;
    @JsonProperty("type")
    private String stock;
    @JsonProperty("description")
    private String description;

    public String getDescription() {
        return description;
    }

    public String getSymbol() {
        return symbol;
    }
}
