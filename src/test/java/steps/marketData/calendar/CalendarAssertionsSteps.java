package steps.marketData.calendar;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.calendar.Calendar;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class CalendarAssertionsSteps {

    @Then("^I get the calendar for the given month$")
    public void iGetTheCalendarForTheGivenMonth(){
        assertThat(String.format("The month and year expected were %s-%s. The obtained were %s-%s.",
                ((Calendar)Share.getShare("calendar")).getMonth(),
                ((Calendar)Share.getShare("calendar")).getYear(),
                ((Calendar)Share.getShare("calendarResponse")).getMonth(),
                ((Calendar)Share.getShare("calendarResponse")).getYear()),
                ((Calendar)Share.getShare("calendar")).getMonth().equals(
                        ((Calendar)Share.getShare("calendarResponse")).getMonth())
            && ((Calendar)Share.getShare("calendar")).getYear().equals(
                    ((Calendar)Share.getShare("calendarResponse")).getYear()));
    }
}
