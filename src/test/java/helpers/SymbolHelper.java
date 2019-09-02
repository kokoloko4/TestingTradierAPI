package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.marketDataEntities.securities.Securities;
import entities.marketDataEntities.securities.Security;
import io.restassured.response.Response;
import utils.RequestFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static modules.APIModule.MARKET_DATA;
import static submodules.APISubmodule.MK_SYMBOLS;

public class SymbolHelper {

    public static Security getCompanies(String httpRequest, String keyword){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("q", keyword);
        Response response = new RequestFactory().createRequest(httpRequest, MARKET_DATA, MK_SYMBOLS
                , queryParams, null);
        ObjectMapper mapper = new ObjectMapper();
        Securities resultSecurities = null;
        try {
            resultSecurities = mapper.readValue(response.getBody().asString(), Securities.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultSecurities.getSecurity();
    }

    public static  boolean validateWord(String word, Security security){
        boolean match = true;
        int cont = 0;
        while(cont < security.getCompanies().size() && match){
            String word1 = security.getCompanies().get(cont).getSymbol().toUpperCase();
            if(!word1.contains(word.toUpperCase())){
                match = false;
            }
            cont++;
        }
        return match;
    }
}
