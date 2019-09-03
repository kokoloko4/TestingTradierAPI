package steps.marketData.calendar;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.calendar.Calendar;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class CalendarAssertionsSteps {

    @Then("^I get the calendar for the given month$")
    public void iGetTheCalendarForTheGivenMonth(){
        Calendar calendar = Share.getShare("calendar");
        Calendar calendarResponse = Share.getShare("calendarResponse");
        assertThat(String.format("The month and year expected were %s-%s. The obtained were %s-%s.", calendar.getMonth(),
                calendar.getYear(), calendarResponse.getMonth(), calendarResponse.getYear()),
                calendar.getMonth().equals(calendarResponse.getMonth())
            && calendar.getYear().equals(calendarResponse.getYear()));
    }
}
