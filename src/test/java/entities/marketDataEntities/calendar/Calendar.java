package entities.marketDataEntities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Calendar {

    @JsonProperty("month")
    private String month;
    @JsonProperty("year")
    private String year;
    @JsonProperty("days")
    private DayCalendar dayCalendar;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public DayCalendar getDayCalendar() {
        return dayCalendar;
    }
}
