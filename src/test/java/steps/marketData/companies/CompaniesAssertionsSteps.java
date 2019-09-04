package steps.marketData.companies;

import cucumber.api.java.en.Then;
import entities.marketDataEntities.securities.Security;
import helpers.SecurityHelper;
import utils.Share;

import static org.hamcrest.MatcherAssert.assertThat;

public class CompaniesAssertionsSteps {

    @Then("^I get a list with all securities$")
    public void iGetAListWithAllSecurities(){
        assertThat("There is one o many companies that does not match the word",
                SecurityHelper.validateWord(Share.getShare("word"), Share.getShare("securities")));
    }
}
