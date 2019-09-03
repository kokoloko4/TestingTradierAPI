package entities.marketDataEntities.securities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public class Security {

    @JsonProperty("security")
    @Getter
    private List<Company> companies;
}
