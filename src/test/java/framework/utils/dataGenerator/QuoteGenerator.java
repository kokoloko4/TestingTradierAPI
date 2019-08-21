package framework.utils.dataGenerator;

import framework.entities.marketDataEntities.Quote;

public class QuoteGenerator {

    public static Quote generateQuote(){
        Quote quote = new Quote();
        quote.setSymbol("AC");
        return quote;
    }
}
