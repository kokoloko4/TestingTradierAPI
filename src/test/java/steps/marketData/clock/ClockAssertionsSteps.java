package steps.marketData.clock;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.clock.Clock;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class ClockAssertionsSteps {

    @Then("^I get the time information about the market$")
    public void iGetTheTimeInformationAboutTheMarket(){
        assertThat(String.format("The description expected was %s and the obtained was %s",
                Share.getShare("opens"), ((Clock)Share.getShare("clock")).getDescription())
                , Share.getShare("opens").equals(((Clock)Share.getShare("clock")).getDescription()));
    }
}
