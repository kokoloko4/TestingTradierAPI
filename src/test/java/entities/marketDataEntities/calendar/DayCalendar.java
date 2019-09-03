package entities.marketDataEntities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public class DayCalendar {

    @JsonProperty("day")
    @Getter
    private List<SpecDay> specDays;

}
