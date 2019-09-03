package entities.marketDataEntities.clock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Clock {

    @JsonProperty("date")
    private String date;
    @JsonProperty("description")
    @Getter
    private String description;
    @JsonProperty("state")
    private String state;
    @JsonProperty("timestamp")
    private long timeStamp;
    @JsonProperty("next_change")
    private String nextChange;
    @JsonProperty("next_state")
    private String nextState;
}
