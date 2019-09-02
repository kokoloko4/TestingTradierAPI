package entities.watchlistEntities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ItemObjects {

    @JsonProperty("item")
    @Getter @Setter
    private List<Item> items;
}
