package entities.marketDataEntities.historicalPrices;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public class History {

    @JsonProperty("day")
    @Getter
    private List<Day> days;
}
