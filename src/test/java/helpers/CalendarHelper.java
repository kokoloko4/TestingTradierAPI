package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.marketDataEntities.calendar.Calendar;
import entities.marketDataEntities.calendar.ResultCalendar;
import io.restassured.response.Response;
import utils.RequestFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static modules.APIModule.MARKET_DATA;
import static submodules.APISubmodule.MK_CALENDAR;

public class CalendarHelper {

    public static Calendar getCalendar(String httpRequest, String month, String year){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("month", month);
        queryParams.put("year", year);
        Response response = new RequestFactory().createRequest(httpRequest, MARKET_DATA, MK_CALENDAR
                , queryParams, null);
        ObjectMapper mapper = new ObjectMapper();
        ResultCalendar calendar = null;
        try {
            calendar = mapper.readValue(response.getBody().asString(), ResultCalendar.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return calendar.getCalendar();
    }
}
