package steps.marketData.companies;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.SecurityHelper;
import utils.Share;

public class CompaniesModuleSteps {

    @Given("^I want the security with the word \"([^\"]*)\" in its description$")
    public void iWantSecurity(String word){
        Share.setShare("word", word);
    }

    @When("^I send a request with the word \"([^\"]*)\" as query$")
    public void iSendARequestWithTheWordAsQuery(String word){
        Share.setShare("securities", SecurityHelper.getCompanies("GET", word));
    }
}
