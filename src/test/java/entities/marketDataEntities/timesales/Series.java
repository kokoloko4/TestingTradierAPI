package entities.marketDataEntities.timesales;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Series {

    @JsonProperty("series")
    private Data series;

    public Data getSeries() {
        return series;
    }
}
