package steps.marketData.expirations;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.expirations.Date;
import helpers.ExpirationsHelper;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class ExpirationsAssertionsSteps {

    @Then("^I get the expiration dates related to the symbol$")
    public void iGetTheExpirationDatesRelatedToTheSymbol(){
        String[] expirations = Share.getShare("expirations");
        Date expirationsResponse = Share.getShare("expirationsResponse");
        assertThat("The dates does not match", ExpirationsHelper.validateDates(expirations,
                expirationsResponse.getExpirations()));
    }
}
