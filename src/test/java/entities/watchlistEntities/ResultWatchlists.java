package entities.watchlistEntities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class ResultWatchlists {

    @JsonProperty("watchlists")
    @Getter @Setter
    private Watchlists watchlists;
}
