package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.marketDataEntities.historicalPrices.Day;
import entities.marketDataEntities.historicalPrices.History;
import entities.marketDataEntities.historicalPrices.ResultHistory;
import io.restassured.response.Response;
import utils.RequestFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static modules.APIModule.MARKET_DATA;
import static submodules.APISubmodule.MK_HISTORICAL_PRICES;

public class HistoricalPricesHelper {

    public static History getHistoricalPrices(String httpRequest, String symbol, String frequency){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("symbol", symbol);
        queryParams.put("interval", frequency);
        Response response = new RequestFactory().createRequest(httpRequest, MARKET_DATA, MK_HISTORICAL_PRICES
                , queryParams, null);
        ObjectMapper mapper = new ObjectMapper();
        ResultHistory resultExpirations = null;
        try {
            resultExpirations = mapper.readValue(response.getBody().asString(), ResultHistory.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultExpirations.getDates();
    }

    public static boolean validateDates(String[] days, List<Day> daysResponse){
        boolean match = true;
        if(days.length == daysResponse.size()){
            int cont = 0;
            while(cont < daysResponse.size() && match){
                if(!days[cont].equals(daysResponse.get(cont).getDate())){
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
