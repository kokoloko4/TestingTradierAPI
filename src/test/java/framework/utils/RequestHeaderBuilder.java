package framework.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestHeaderBuilder {

    private RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    private final String baseUri = "https://sandbox.tradier.com/v1/";

    public RequestHeaderBuilder(){
        this.requestSpecBuilder.setBaseUri(this.baseUri)
                .setAccept(ContentType.JSON)
                .addHeader("Authorization","Bearer 9uiInA0AOqKESq4DjflqtDGwNUrG");
    }

    public RequestSpecBuilder withBasePath(String basePath){
        return this.requestSpecBuilder
                .setBasePath(basePath);
    }

    public RequestSpecBuilder withContentType(ContentType contentType){
        return this.requestSpecBuilder
                .setContentType(contentType);
    }

    public RequestSpecBuilder withParams(Map<String, String> params){
        return this.requestSpecBuilder
                .addParams(params);
    }

    public RequestSpecBuilder withQueryParams(Map<String, String> params){
        return this.requestSpecBuilder
                .addQueryParams(params);
    }

    public RequestSpecification build(){
        return this.requestSpecBuilder.build();
    }
}
