package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.marketDataEntities.timesales.Data;
import entities.marketDataEntities.timesales.Series;
import entities.marketDataEntities.timesales.TimeSales;
import io.restassured.response.Response;
import utils.RequestFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static modules.APIModule.MARKET_DATA;
import static submodules.APISubmodule.MK_TIME_SALES;

public class TimeSalesHelper {

    public static Data getTimeSales(String httpRequest, String symbol){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("symbol", symbol);
        Response response = new RequestFactory().createRequest(httpRequest, MARKET_DATA, MK_TIME_SALES
                , queryParams, null);
        ObjectMapper mapper = new ObjectMapper();
        Series resultSeries = null;
        try {
            resultSeries = mapper.readValue(response.getBody().asString(), Series.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultSeries.getSeries();
    }

    public static boolean verifyTimeIsActualDay(String currentDate, Data data){
        boolean match = true;
        int cont = 0;
        while(cont < data.getTimesales().size() && match){
            if(!data.getTimesales().get(cont).getTime().split("T")[0].equals(currentDate)){
                match = false;
            }
            cont++;
        }
        return match;
    }
}
