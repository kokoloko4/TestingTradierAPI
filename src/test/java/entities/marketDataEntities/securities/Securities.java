package entities.marketDataEntities.securities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Securities {

    @JsonProperty("securities")
    private Security security;

    public Security getSecurity() {
        return security;
    }
}
