package entities.marketDataEntities.securities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Company {

    @JsonProperty("symbol")
    @Getter
    private String symbol;
    @JsonProperty("exchange")
    private String exchange;
    @JsonProperty("type")
    private String stock;
    @JsonProperty("description")
    @Getter
    private String description;
}
