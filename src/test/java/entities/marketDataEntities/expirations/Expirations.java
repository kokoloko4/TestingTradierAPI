package entities.marketDataEntities.expirations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Expirations {

    @JsonProperty("expirations")
    @Getter
    private Date dates;
}
