package steps.marketData.expirations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.ExpirationsHelper;
import utils.Share;
import utils.dataGenerator.ExpirationsDateGenerator;

public class ExpirationsModuleSteps {

    @Given("^I have a list of expirations of \"([^\"]*)\"$")
    public void iHaveAListExpirations(String symbol){
        String[] expirations = ExpirationsDateGenerator.getExpirations();
        Share.setShare("expirations", expirations);
    }

    @When("^I send a request to expirations module with the symbol \"([^\"]*)\"$")
    public void iSendARequestToExpirationsModuleWithTheSymbol(String symbol){
        Share.setShare("expirationsResponse", ExpirationsHelper.getExpirations("GET", symbol));
    }
}
