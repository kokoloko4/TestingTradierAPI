package entities.marketDataEntities.quotes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Quote {

    @JsonProperty("symbol")
    @Getter @Setter
    private String symbol;
    @JsonProperty("description")
    private String description;
    @JsonProperty("exch")
    private String exch;
    @JsonProperty("type")
    private String type;
    @JsonProperty("last")
    private long last;
    @JsonProperty("change")
    private long change;
    @JsonProperty("volume")
    private long volume;
    @JsonProperty("open")
    private long open;
    @JsonProperty("high")
    private long high;
    @JsonProperty("low")
    private long low;
    @JsonProperty("close")
    private String close;
    @JsonProperty("bid")
    private long bid;
    @JsonProperty("ask")
    private long ask;
    @JsonProperty("underlying")
    private String underlying;
    @JsonProperty("strike")
    private long strike;
    @JsonProperty("change_percentage")
    private long changePercentage;
    @JsonProperty("average_volume")
    private long averageVolume;
    @JsonProperty("last_volume")
    private long lastVolume;
    @JsonProperty("trade_date")
    private long tradeDate;
    @JsonProperty("prevclose")
    private long prevClose;
    @JsonProperty("week_52_high")
    private long week52High;
    @JsonProperty("week_52_low")
    private long week52Low;
    @JsonProperty("bidsize")
    private long bidsize;
    @JsonProperty("bidexch")
    private String bidExch;
    @JsonProperty("bid_date")
    private long bidDate;
    @JsonProperty("asksize")
    private long askSize;
    @JsonProperty("askexch")
    private String askExch;
    @JsonProperty("ask_date")
    private long askDate;
    @JsonProperty("open_interest")
    private long openInterest;
    @JsonProperty("contract_size")
    private long contractSize;
    @JsonProperty("expiration_date")
    @Getter @Setter
    private String expirationDate;
    @JsonProperty("expiration_type")
    private String expirationType;
    @JsonProperty("option_type")
    private String optionType;
    @JsonProperty("root_symbol")
    @Getter @Setter
    private String rootSymbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getRootSymbol() {
        return rootSymbol;
    }

    public void setRootSymbol(String rootSymbol) {
        this.rootSymbol = rootSymbol;
    }
}
