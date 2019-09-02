package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.marketDataEntities.expirations.Date;
import entities.marketDataEntities.expirations.Expirations;
import io.restassured.response.Response;
import utils.RequestFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static modules.APIModule.MARKET_DATA;
import static submodules.APISubmodule.MK_OPTIONS_EXPIRATIONS;

public class ExpirationsHelper {

    public static Date getExpirations(String httpRequest, String symbol){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("symbol", symbol);
        Response response = new RequestFactory().createRequest(httpRequest, MARKET_DATA, MK_OPTIONS_EXPIRATIONS
                , queryParams, null);
        ObjectMapper mapper = new ObjectMapper();
        Expirations resultExpirations = null;
        try {
            resultExpirations = mapper.readValue(response.getBody().asString(), Expirations.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultExpirations.getDates();
    }

    public static boolean validateDates(String[] expirations, String[] expirationsResponse){
        boolean match = true;
        if(expirations.length == expirationsResponse.length){
            int cont = 0;
            while(cont < expirations.length && match){
                if(!expirations[cont].equals(expirationsResponse[cont])){
                    match = false;
                }
                cont++;
            }
        }else{
            match = false;
        }
        return match;
    }
}
