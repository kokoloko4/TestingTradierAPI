package framework.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestFactory {
    public RequestSpecification createHeaderMarketData(Boolean haveContentType, Map<String,String> params){
        if(haveContentType){
            return new RequestHeaderBuilder().withBasePath("markets")
        }
        return new RequestHeaderBuilder().build();
    }
    public Response createResponseWithMarkets(RequestSpecification requestSpecification, String path){
        Response response = new RequestFactory()
                .createResponseWithMarkets(requestSpecification, "quotes");
        return new RequestResponseBuilder(requestSpecification)
                .isMarkets(path);
    }
}
