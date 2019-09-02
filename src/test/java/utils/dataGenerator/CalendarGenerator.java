package utils.dataGenerator;

import entities.marketDataEntities.calendar.Calendar;

public class CalendarGenerator {

    public static Calendar getCalendar(String month, String year){
        Calendar calendar = new Calendar();
        calendar.setMonth(month);
        calendar.setYear(year);
        return calendar;
    }
}
