package steps.marketData.calendar;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.marketDataEntities.calendar.Calendar;
import helpers.CalendarHelper;
import utils.Share;
import utils.dataGenerator.CalendarGenerator;

public class CalendarModuleSteps {

    @Given("^I want the calendar of \"([^\"]*)\" of \"([^\"]*)\"$")
    public void iHaveTheCalendar(String month, String year){
        Calendar calendar = CalendarGenerator.getCalendar(month, year);
        Share.setShare("calendar", calendar);
    }

    @When("I send a request with the month \"([^\"]*)\" of year \"([^\"]*)\"$")
    public void ISendARequestWithTheMonthOfYear(String month, String year){
        Share.setShare("calendarResponse", CalendarHelper.getCalendar("GET", month, year));
    }
}
