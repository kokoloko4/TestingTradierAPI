package steps.marketData.clock;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.clock.Clock;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class ClockAssertionsSteps {

    @Then("^I get the time information about the market$")
    public void iGetTheTimeInformationAboutTheMarket(){
        String description = Share.getShare("opens");
        Clock clock = Share.getShare("clock");
        assertThat(String.format("The description expected was %s and the obtained was %s", description, clock.getDescription())
                , description.equals(clock.getDescription()));
    }
}
