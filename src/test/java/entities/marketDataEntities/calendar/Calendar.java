package entities.marketDataEntities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Calendar {

    @JsonProperty("month")
    @Getter @Setter
    private String month;
    @JsonProperty("year")
    @Getter @Setter
    private String year;
    @JsonProperty("days")
    @Getter @Setter
    private DayCalendar dayCalendar;
}
