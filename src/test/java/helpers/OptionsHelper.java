package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.marketDataEntities.options.Options;
import entities.marketDataEntities.options.ResultOption;
import entities.marketDataEntities.quotes.Quote;
import io.restassured.response.Response;
import utils.RequestFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static modules.APIModule.MARKET_DATA;
import static submodules.APISubmodule.MK_OPTIONS_CHAINS;

public class OptionsHelper {

    public static Options getOptions(String httpRequest, String symbol, String date){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("symbol", symbol);
        queryParams.put("expiration", date);
        Response response = new RequestFactory().createRequest(httpRequest, MARKET_DATA, MK_OPTIONS_CHAINS
                , queryParams, null);
        ObjectMapper mapper = new ObjectMapper();
        ResultOption resultOptions = null;
        try {
            resultOptions = mapper.readValue(response.getBody().asString(), ResultOption.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultOptions.getOptions();
    }

    public static boolean verifyOptions(Quote option, List<Quote> options){
        boolean match = true;
        int cont = 0;
        while(cont < options.size() && match){
            if(!options.get(cont).getRootSymbol().equals(option.getRootSymbol()) ||
                    !options.get(cont).getExpirationDate().equals(option.getExpirationDate())){
                match = false;
            }
            cont++;
        }
        return match;
    }
}
