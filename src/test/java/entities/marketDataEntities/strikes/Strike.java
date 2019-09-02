package entities.marketDataEntities.strikes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Strike {

    @JsonProperty("strike")
    @Getter
    private Double[] strikes;
}
