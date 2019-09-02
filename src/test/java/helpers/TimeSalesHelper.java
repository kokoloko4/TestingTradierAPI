package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.marketDataEntities.timesales.Data;
import entities.marketDataEntities.timesales.Series;
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
}
