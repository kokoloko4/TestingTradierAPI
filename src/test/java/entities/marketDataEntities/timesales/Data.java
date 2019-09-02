package entities.marketDataEntities.timesales;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("data")
    private TimeSales timesales;

    public TimeSales getTimesales() {
        return timesales;
    }
}
