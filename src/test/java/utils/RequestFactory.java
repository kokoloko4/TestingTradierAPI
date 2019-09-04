package utils;

import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSenderOptions;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static modules.APIModule.MARKET_DATA;
import static modules.APIModule.WATCHLISTS;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static submodules.APISubmodule.*;

public class RequestFactory {

    private static String baseURI;

    public Response createRequest(String httpRequest, String module, String submodule, Map<String, String> queryParams,
                                  Map<String, String> requestBody){
        ReadProperties readProperties = new ReadProperties("data");
        readProperties.openFile();
        baseURI = readProperties.getProperty("baseURI");
        readProperties.closeFile();
        RequestBuilder requestBuilder = new RequestBuilder(baseURI);
        if(module.equals(MARKET_DATA)){
            requestBuilder.withBasePath(MARKET_DATA);
            switch (submodule){
                case MK_QUOTES:
                    if(httpRequest.equals("POST")){
                        requestBuilder.withContentType(ContentType.URLENC)
                                .withContentParams(requestBody);
                        return postRequest(requestBuilder.build(), MK_QUOTES);
                    }
                    requestBuilder.withQueryParams(queryParams);
                    return getRequest(requestBuilder.build(), MK_QUOTES);
                case MK_OPTIONS_CHAINS:
                    requestBuilder.withQueryParams(queryParams);
                    return getRequest(requestBuilder.build(), MK_OPTIONS_CHAINS);
                case MK_OPTIONS_STRIKES:
                    requestBuilder.withQueryParams(queryParams);
                    return getRequest(requestBuilder.build(), MK_OPTIONS_STRIKES);
                case MK_OPTIONS_EXPIRATIONS:
                    requestBuilder.withQueryParams(queryParams);
                    return getRequest(requestBuilder.build(), MK_OPTIONS_EXPIRATIONS);
                case MK_HISTORICAL_PRICES:
                    requestBuilder.withQueryParams(queryParams);
                    return getRequest(requestBuilder.build(), MK_HISTORICAL_PRICES);
                case MK_TIME_SALES:
                    requestBuilder.withQueryParams(queryParams);
                    return getRequest(requestBuilder.build(), MK_TIME_SALES);
                case MK_CLOCK:
                    return getRequest(requestBuilder.build(), MK_CLOCK);
                case MK_CALENDAR:
                    requestBuilder.withQueryParams(queryParams);
                    return getRequest(requestBuilder.build(), MK_CALENDAR);
                case MK_SYMBOLS:
                    requestBuilder.withQueryParams(queryParams);
                    return getRequest(requestBuilder.build(), MK_SYMBOLS);
                case MK_COMPANIES:
                    requestBuilder.withQueryParams(queryParams);
                    return getRequest(requestBuilder.build(), MK_COMPANIES);
                default:
                    break;
            }
        }else if(module.equals(WATCHLISTS)){
            requestBuilder.withBasePath(WATCHLISTS);
            switch (submodule){
                case WL_ALL:
                    return getRequest(requestBuilder.build(), "");
                case WL_ONE:
                    return getRequest(requestBuilder.build(), queryParams.get("watchlist_id"));
                case WL_CREATE:
                    requestBuilder.withContentType(ContentType.URLENC)
                            .withContentParams(requestBody);
                    return postRequest(requestBuilder.build(), "");
                case WL_DELETE:
                    return deleteRequest(requestBuilder.build(), queryParams.get("watchlist_id"));
                case WL_UPDATE:
                    requestBuilder.withContentType(ContentType.URLENC).withContentParams(requestBody);
                    return putRequest(requestBuilder.build(), queryParams.get("watchlist_id"));
                case WL_ADD_SYMBOLS:
                    requestBuilder.withContentType(ContentType.URLENC).withContentParams(requestBody);
                    return postRequest(requestBuilder.build(), queryParams.get("watchlist_id")+"/symbols");
                case WL_REMOVE_SYMBOL:
                    return deleteRequest(requestBuilder.build(), queryParams.get("watchlist_id")+"/symbols"
                            +queryParams.get("symbol"));
                default:
                    break;
            }
        }
        return null;
    }

    private Response getRequest(RequestSpecification requestSpecification, String path){
        Response response = given().spec(requestSpecification).when().get(path);
        statusCode200(response);
        return response.then().extract().response();
    }

    private Response postRequest(RequestSpecification requestSpecification, String path){
        Response response = given().spec(requestSpecification).when().post(path);
        statusCode200(response);
        return response.then().extract().response();
    }

    private Response putRequest(RequestSpecification requestSpecification, String path){
        Response response = given().spec(requestSpecification).when().put(path);
        statusCode200(response);
        return response.then().extract().response();
    }

    private Response deleteRequest(RequestSpecification requestSpecification, String path){
        Response response = given().spec(requestSpecification).when().delete(path);
        statusCode200(response);
        return response.then().extract().response();    }

    private void statusCode200(Response response){
        assertThat(String.format("The expected code is %d but was %d", response.getStatusCode(), SC_OK),
                response.getStatusCode(), equalTo(SC_OK));
    }
}
