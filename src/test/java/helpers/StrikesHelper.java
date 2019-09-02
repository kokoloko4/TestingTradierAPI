package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.marketDataEntities.strikes.Strike;
import entities.marketDataEntities.strikes.Strikes;
import io.restassured.response.Response;
import utils.RequestFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static modules.APIModule.MARKET_DATA;
import static submodules.APISubmodule.MK_OPTIONS_STRIKES;
import static submodules.APISubmodule.MK_QUOTES;

public class StrikesHelper {

    public static Strike getStrikes(String httpRequest, String symbol, String date){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("symbol", symbol);
        queryParams.put("expiration", date);
        Response response = new RequestFactory().createRequest(httpRequest, MARKET_DATA, MK_OPTIONS_STRIKES
                , queryParams, null);
        ObjectMapper mapper = new ObjectMapper();
        Strikes resultQuotes = null;
        try {
            resultQuotes = mapper.readValue(response.getBody().asString(), Strikes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultQuotes.getStrikes();
    }

    public static boolean verifyStrikes(Double[] strikes, Double[] responseStrikes){
        boolean match = true;
        if(strikes.length == responseStrikes.length){
            int cont = 0;
            while(cont < responseStrikes.length && match){
                if(!strikes[cont].equals(responseStrikes[cont])){
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
