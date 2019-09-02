package entities.marketDataEntities.clock;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clock {

    @JsonProperty("date")
    private String date;
    @JsonProperty("description")
    private String description;
    @JsonProperty("state")
    private String state;
    @JsonProperty("timestamp")
    private long timeStamp;
    @JsonProperty("next_change")
    private String nextChange;
    @JsonProperty("next_state")
    private String nextState;

    public String getDescription() {
        return description;
    }
}
