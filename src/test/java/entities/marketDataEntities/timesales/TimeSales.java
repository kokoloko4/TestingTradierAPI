package entities.marketDataEntities.timesales;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSales {

    @JsonProperty("time")
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

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
