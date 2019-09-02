package utils.dataGenerator;

import entities.marketDataEntities.timesales.TimeSales;

public class TimeSalesGenerator {

    public static TimeSales getTimeSales(String time){
        TimeSales timeSales = new TimeSales();
        timeSales.setTime(time);
        return timeSales;
    }
}
