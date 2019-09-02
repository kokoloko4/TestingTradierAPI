package entities.marketDataEntities.strikes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Strikes {

    @JsonProperty("strikes")
    @Getter
    private Strike strikes;

    public Strike getStrikes() {
        return strikes;
    }
}
