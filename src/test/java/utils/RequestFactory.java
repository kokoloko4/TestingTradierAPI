package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static modules.APIModule.MARKET_DATA;
import static modules.APIModule.WATCHLISTS;
import static org.apache.http.HttpStatus.SC_OK;
import static submodules.APISubmodule.*;

public class RequestFactory {

    private static String baseURI = System.getenv("baseURI");

    public Response createRequest(String httpRequest, String module, String submodule, Map<String, String> queryParams,
                                  Map<String, String> requestBody){
        RequestBuilder requestBuilder = new RequestBuilder(baseURI);
        if(module.equals(MARKET_DATA)){
            requestBuilder.withBasePath(MARKET_DATA).withQueryParams(queryParams);
            switch (submodule){
                case MK_QUOTES:
                    if(httpRequest.equals("POST")){
                        requestBuilder.withContentType(ContentType.URLENC)
                                .withContentParams(requestBody);
                    }
                    return createResponse(requestBuilder.build(), MK_QUOTES, httpRequest);
                case MK_OPTIONS_CHAINS:
                    return createResponse(requestBuilder.build(), MK_OPTIONS_CHAINS, httpRequest);
                case MK_OPTIONS_STRIKES:
                    return createResponse(requestBuilder.build(), MK_OPTIONS_STRIKES, httpRequest);
                case MK_OPTIONS_EXPIRATIONS:
                    return createResponse(requestBuilder.build(), MK_OPTIONS_EXPIRATIONS, httpRequest);
                case MK_HISTORICAL_PRICES:
                    return createResponse(requestBuilder.build(), MK_HISTORICAL_PRICES, httpRequest);
                case MK_TIME_SALES:
                    return createResponse(requestBuilder.build(), MK_TIME_SALES, httpRequest);
                case MK_CLOCK:
                    return createResponse(requestBuilder.build(), MK_CLOCK, httpRequest);
                case MK_CALENDAR:
                    return createResponse(requestBuilder.build(), MK_CALENDAR, httpRequest);
                case MK_SYMBOLS:
                    return createResponse(requestBuilder.build(), MK_SYMBOLS, httpRequest);
                case MK_COMPANIES:
                    return createResponse(requestBuilder.build(), MK_COMPANIES, httpRequest);
                default:
                    break;
            }
        }else if(module.equals(WATCHLISTS)){
            requestBuilder.withBasePath(WATCHLISTS);
            switch (submodule){
                case WL_ALL:
                    return createResponse(requestBuilder.build(), "", "GET");
                case WL_ONE:
                    return createResponse(requestBuilder.build(), queryParams.get("id"), "GET");
                case WL_CREATE:
                    requestBuilder.withContentType(ContentType.URLENC)
                            .withContentParams(requestBody);
                    return createResponse(requestBuilder.build(), "", "POST");
                case WL_DELETE:
                    break;
                case WL_UPDATE:
                    break;
                case WL_ADD_SYMBOLS:
                    break;
                case WL_REMOVE_SYMBOL:
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    private Response createResponse(RequestSpecification requestSpecification, String path, String httpRequest){
        Response response = null;
        RequestSpecification responseSpec = given()
                .spec(requestSpecification);
        if(httpRequest.equals("GET")){
            response = responseSpec.get(path);
        }else if(httpRequest.equals("POST")){
            response = responseSpec.post(path);
        }
        if(response != null){
            response.then()
                    .assertThat()
                    .statusCode(SC_OK)
                    .extract()
                    .response();
        }
        return response;
    }
}
