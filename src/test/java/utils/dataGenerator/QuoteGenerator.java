package utils.dataGenerator;

import entities.marketDataEntities.quotes.Quote;

public class QuoteGenerator {

    public static Quote generateQuote(String symbol){
        Quote quote = new Quote();
        quote.setSymbol(symbol);
        return quote;
    }

    public static Quote generateOption(String symbol, String expirationDate){
        Quote quote = new Quote();
        quote.setRootSymbol(symbol);
        quote.setExpirationDate(expirationDate);
        return quote;
    }
}
