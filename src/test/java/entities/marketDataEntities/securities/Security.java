package entities.marketDataEntities.securities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Security {

    @JsonProperty("security")
    private List<Company> companies;

    public List<Company> getCompanies() {
        return companies;
    }
}
