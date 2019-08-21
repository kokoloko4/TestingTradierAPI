package framework.helpers;

import framework.utils.RequestFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class QuotesHelper {

    public Response getQuotes(String symbols){
        RequestFactory requestFactory = new RequestFactory();
        Map<String,String> params = new HashMap<>();
        params.put("symbols", symbols);
        RequestSpecification requestSpecification = requestFactory.createGetRequest("markets",params);
        return requestFactory.createResponse(requestSpecification, "quotes");
    }
}
