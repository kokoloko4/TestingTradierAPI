package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.marketDataEntities.clock.Clock;
import io.restassured.response.Response;
import utils.RequestFactory;

import java.io.IOException;

import static modules.APIModule.MARKET_DATA;
import static submodules.APISubmodule.MK_CLOCK;

public class ClockHelper {

    public static Clock getClock(String httpRequest){
        Response response = new RequestFactory().createRequest(httpRequest, MARKET_DATA, MK_CLOCK
                , null, null);
        ObjectMapper mapper = new ObjectMapper();
        Clock clock = null;
        try {
            clock = mapper.readValue(response.getBody().asString(), Clock.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clock;
    }
}
