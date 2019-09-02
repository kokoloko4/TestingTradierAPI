package entities.marketDataEntities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultCalendar {

    @JsonProperty("calendar")
    private Calendar calendar;

    public Calendar getCalendar() {
        return calendar;
    }
}
