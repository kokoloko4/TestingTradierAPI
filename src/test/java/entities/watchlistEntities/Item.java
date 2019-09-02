package entities.watchlistEntities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Item {

    @JsonProperty("symbol")
    @Getter @Setter
    private String symbol;
    @JsonProperty("id")
    private String id;
}
