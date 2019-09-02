package entities.watchlistEntities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Watchlist {

    @JsonProperty("name")
    @Getter @Setter
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("public_id")
    private String publicId;
    @JsonProperty("items")
    @Getter @Setter
    private ItemObjects itemObjects;
}
