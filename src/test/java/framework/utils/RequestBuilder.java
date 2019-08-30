package framework.utils;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestBuilder {

    private RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    private final String baseUri = "https://sandbox.tradier.com/v1/";

    public RequestBuilder(){
        this.requestSpecBuilder.setBaseUri(this.baseUri)
                .setAccept(ContentType.JSON)//.setAuth()
                .addHeader("Authorization","Bearer "+ AccessToken.getAccessToken());
    }

    public RequestBuilder withBasePath(String basePath){
        this.requestSpecBuilder
                .setBasePath(basePath);
        return this;
    }

    public RequestBuilder withContentType(ContentType contentType){
        this.requestSpecBuilder
                .setContentType(contentType);
        return this;
    }

    public RequestBuilder withParams(Map<String, String> params){
        this.requestSpecBuilder
                .addParams(params);
        return this;
    }

    public RequestBuilder withQueryParams(Map<String, String> params){
        this.requestSpecBuilder
                .addQueryParams(params);
        return this;
    }

    public RequestSpecification build(){
        return this.requestSpecBuilder.build();
    }
}
