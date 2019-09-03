package entities.marketDataEntities.securities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Securities {

    @JsonProperty("securities")
    @Getter
    private Security security;
}
