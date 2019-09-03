package entities.marketDataEntities.expirations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Date {

    @JsonProperty("date")
    @Getter
    private String[] expirations;

}
