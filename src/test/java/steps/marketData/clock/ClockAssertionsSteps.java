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
        assertThat("The description is not the same", description.equals(clock.getDescription()));
    }
}
