package entities.marketDataEntities.expirations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Date {

    @JsonProperty("date")
    private String[] expirations;

    public String[] getExpirations() {
        return expirations;
    }
}
