package entities.marketDataEntities.clock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class ResultClock {

    @JsonProperty("clock")
    @Getter
    private Clock clock;
}
