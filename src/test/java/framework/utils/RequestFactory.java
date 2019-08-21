package framework.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestFactory {

    public RequestSpecification createGetRequest(String basePath, Map<String, String> queryParams){
        return new RequestBuilder()
                .withBasePath(basePath)
                .withQueryParams(queryParams)
                .build();
    }

    public Response createResponse(RequestSpecification requestSpecification, String path){
        return new ResponseBuilder(requestSpecification, path).validateResponse();
    }
}
