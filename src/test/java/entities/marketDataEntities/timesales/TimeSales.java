package entities.marketDataEntities.timesales;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class TimeSales {

    @JsonProperty("time")
    @Getter @Setter
    private String time;
    @JsonProperty("timestamp")
    private long timeStamp;
    @JsonProperty("price")
    private long price;
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
    @JsonProperty("vwap")
    private long vwap;
}
