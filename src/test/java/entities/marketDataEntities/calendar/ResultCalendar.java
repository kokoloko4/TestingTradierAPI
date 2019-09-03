package entities.marketDataEntities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class ResultCalendar {

    @JsonProperty("calendar")
    @Getter
    private Calendar calendar;

}
