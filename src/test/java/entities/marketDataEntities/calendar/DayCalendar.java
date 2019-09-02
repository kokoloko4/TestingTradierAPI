package entities.marketDataEntities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DayCalendar {

    @JsonProperty("day")
    private List<SpecDay> specDays;

    public List<SpecDay> getSpecDays() {
        return specDays;
    }
}
