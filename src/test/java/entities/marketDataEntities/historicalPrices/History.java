package entities.marketDataEntities.historicalPrices;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class History {

    @JsonProperty("day")
    private List<Day> days;

    public List<Day> getDays() {
        return days;
    }
}
