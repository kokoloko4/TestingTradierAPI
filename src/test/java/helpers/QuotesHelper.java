package helpers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.marketDataEntities.quotes.Quote;
import entities.marketDataEntities.quotes.Quotes;
import entities.marketDataEntities.quotes.ResultQuotes;
import utils.RequestFactory;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static modules.APIModule.MARKET_DATA;
import static submodules.APISubmodule.MK_QUOTES;

public class QuotesHelper {

    public static Quotes getQuotes(String httpRequest, String symbols){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("symbols", symbols);
        Response response = new RequestFactory().createRequest(httpRequest, MARKET_DATA, MK_QUOTES
                , queryParams, null);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        ResultQuotes resultQuotes = null;
        try {
            resultQuotes = mapper.readValue(response.getBody().asString(), ResultQuotes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultQuotes.getQuotes();
    }

    public static Quotes postQuotes(String httpRequest, String symbols){
        Map<String, String> contentParams = new HashMap<>();
        contentParams.put("symbols", symbols);
        Response response = new RequestFactory().createRequest(httpRequest, MARKET_DATA, MK_QUOTES
                , null, contentParams);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        ResultQuotes resultQuotes = null;
        try {
            resultQuotes = mapper.readValue(response.getBody().asString(), ResultQuotes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultQuotes.getQuotes();
    }

    public static boolean responseContainsSymbols(Quotes quote, Quotes response){
        boolean match = true;
        int cont = 0;
        while(cont < quote.getQuotes().size() && match){
            if(!quote.getQuotes().get(cont).getSymbol().equals(response.getQuotes().get(cont).getSymbol())){
                match = false;
            }
            cont++;
        }
        return match;
    }
}
