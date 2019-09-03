package entities.marketDataEntities.timesales;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Series {

    @JsonProperty("series")
    @Getter
    private Data series;
}
