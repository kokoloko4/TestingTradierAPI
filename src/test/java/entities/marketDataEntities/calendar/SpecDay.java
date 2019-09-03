package entities.marketDataEntities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class SpecDay {

    @JsonProperty("date")
    @Getter
    private String date;
    @JsonProperty("status")
    private String status;
    @JsonProperty("description")
    private String description;
    @JsonProperty("premarket")
    private Hours premarket;
    @JsonProperty("open")
    private Hours open;
    @JsonProperty("postmarket")
    private Hours postMarket;
}
