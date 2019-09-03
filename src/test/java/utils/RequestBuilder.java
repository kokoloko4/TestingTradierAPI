package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestBuilder {

    private RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

    public RequestBuilder(String baseUri){
        ReadProperties readProperties = new ReadProperties("data");
        readProperties.openFile();
        this.requestSpecBuilder.setBaseUri(baseUri)
                .setAccept(ContentType.JSON)
                .setAuth(RestAssured.oauth2(readProperties.getProperty("token")));
        readProperties.closeFile();
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

    public RequestBuilder withContentParams(Map<String, String> params){
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
