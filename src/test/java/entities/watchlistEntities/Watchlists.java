package entities.watchlistEntities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Watchlists {

    @JsonProperty("watchlist")
    @Getter @Setter
    private List<Watchlist> watchlistList;
}
