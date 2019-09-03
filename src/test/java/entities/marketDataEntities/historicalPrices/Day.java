package entities.marketDataEntities.historicalPrices;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Day {

    @JsonProperty("date")
    @Getter
    private String date;
    @JsonProperty("open")
    private long open;
    @JsonProperty("high")
    private long high;
    @JsonProperty("low")
    private long low;
    @JsonProperty("close")
    private long close;
    @JsonProperty("volume")
    private long volume;
}
