package framework.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ResponseBuilder {

    private RequestSpecification requestSpecification;
    private Response response;

    public ResponseBuilder(RequestSpecification requestSpecification, String path){
        this.response = given().spec(requestSpecification)
                .get(path);
    }

    public Response validateResponse(){
        return this.response.then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .response();
    }
}
