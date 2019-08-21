package framework.steps.marketData;

import cucumber.api.java.en.Given;
import framework.utils.RequestFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class MarketDataSteps {

    //@Given("I have an access token$")
    @Test
    public void IHaveAndAccessToken(){
        RequestSpecification requestSpecification = new RequestFactory().
                createHeaderMarketData(false,null);
        Response response = new RequestFactory().createResponseWithMarkets(requestSpecification, "quotes");
        /*Response response = given()
                .spec(requestSpecification)
                .queryParam("symbols","AAPL")
                .get("markets/quotes")
                .then()
                .statusCode(SC_OK)
                .extract()
                .response();*/
        System.out.println("*************"+ response.toString());
    }
}
