package framework.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class RequestResponseBuilder {

    private RequestSpecification requestSpecification;
    private Response response;

    public RequestResponseBuilder(RequestSpecification requestSpecification){
        this.requestSpecification = given().spec(requestSpecification);
    }

    public Response getQuotes(String path){
        this.response = this.requestSpecification
                .get(path);
        verifyResponse(this.response);
        return this.response;
    }

    private void verifyResponse(Response response){
        response
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract();
    }
}
