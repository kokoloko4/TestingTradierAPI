package entities.marketDataEntities.timesales;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public class Data {

    @JsonProperty("data")
    @Getter
    private List<TimeSales> timesales;
}
