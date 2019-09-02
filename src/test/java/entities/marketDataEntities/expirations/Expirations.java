package entities.marketDataEntities.expirations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Expirations {

    @JsonProperty("expirations")
    private Date dates;

    public Date getDates() {
        return dates;
    }
}
