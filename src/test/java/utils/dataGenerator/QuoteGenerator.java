package utils.dataGenerator;

import entities.marketDataEntities.quotes.Quote;

public class QuoteGenerator {

    public static Quote generateQuote(){
        Quote quote = new Quote();
        quote.setSymbol("AC");
        return quote;
    }
}
