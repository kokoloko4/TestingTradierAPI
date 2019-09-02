package entities.marketDataEntities.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


public class ResultOption {

    @JsonProperty("options")
    @Getter
    private Options options;
}
