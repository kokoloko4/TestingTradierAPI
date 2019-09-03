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
                    }else{
                        requestBuilder.withQueryParams(queryParams);
                    }
                    return createResponse(requestBuilder.build(), MK_QUOTES, httpRequest);
                case MK_OPTIONS_CHAINS:
                    requestBuilder.withQueryParams(queryParams);
                    return createResponse(requestBuilder.build(), MK_OPTIONS_CHAINS, httpRequest);
                case MK_OPTIONS_STRIKES:
                    requestBuilder.withQueryParams(queryParams);
                    return createResponse(requestBuilder.build(), MK_OPTIONS_STRIKES, httpRequest);
                case MK_OPTIONS_EXPIRATIONS:
                    requestBuilder.withQueryParams(queryParams);
                    return createResponse(requestBuilder.build(), MK_OPTIONS_EXPIRATIONS, httpRequest);
                case MK_HISTORICAL_PRICES:
                    requestBuilder.withQueryParams(queryParams);
                    return createResponse(requestBuilder.build(), MK_HISTORICAL_PRICES, httpRequest);
                case MK_TIME_SALES:
                    requestBuilder.withQueryParams(queryParams);
                    return createResponse(requestBuilder.build(), MK_TIME_SALES, httpRequest);
                case MK_CLOCK:
                    return createResponse(requestBuilder.build(), MK_CLOCK, httpRequest);
                case MK_CALENDAR:
                    requestBuilder.withQueryParams(queryParams);
                    return createResponse(requestBuilder.build(), MK_CALENDAR, httpRequest);
                case MK_SYMBOLS:
                    requestBuilder.withQueryParams(queryParams);
                    return createResponse(requestBuilder.build(), MK_SYMBOLS, httpRequest);
                case MK_COMPANIES:
                    requestBuilder.withQueryParams(queryParams);
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
                    return createResponse(requestBuilder.build(), queryParams.get("watchlist_id"), httpRequest);
                case WL_CREATE:
                    requestBuilder.withContentType(ContentType.URLENC)
                            .withContentParams(requestBody);
                    return createResponse(requestBuilder.build(), "", "POST");
                case WL_DELETE:
                    return createResponse(requestBuilder.build(), queryParams.get("watchlist_id"), httpRequest);
                case WL_UPDATE:
                    requestBuilder.withContentType(ContentType.URLENC).withContentParams(requestBody);
                    return createResponse(requestBuilder.build(), queryParams.get("watchlist_id"), httpRequest);
                case WL_ADD_SYMBOLS:
                    requestBuilder.withContentType(ContentType.URLENC).withContentParams(requestBody);
                    return createResponse(requestBuilder.build(), queryParams.get("watchlist_id")+"/symbols", httpRequest);
                case WL_REMOVE_SYMBOL:
                    return createResponse(requestBuilder.build(), queryParams.get("watchlist_id")+"/symbols"
                            +queryParams.get("symbol"), httpRequest);
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
        switch (httpRequest){
            case "GET":
                response = responseSpec.get(path);
                break;
            case "POST":
                response = responseSpec.post(path);
                break;
            case "PUT":
                response = responseSpec.put(path);
                break;
            case "DELETE":
                response = responseSpec.delete(path);
                break;
        }
        try{
            response.then()
                    .statusCode(SC_OK)
                    .extract()
                    .response();
        }catch(Exception e){
            System.out.println("The response obtained is empty");
        }
        return response;
    }
}
