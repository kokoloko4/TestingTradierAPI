package utils.dataGenerator;

import entities.marketDataEntities.quotes.Quote;
import entities.marketDataEntities.quotes.Quotes;

import java.util.ArrayList;
import java.util.List;

public class QuoteGenerator {

    public static Quote generateQuote(String symbol){
        Quote quote = new Quote();
        quote.setSymbol(symbol);
        return quote;
    }

    public static Quotes generateQuotes(String symbols){
        Quotes quotes = new Quotes();
        List<Quote> listQuotes = new ArrayList<>();
        for (String symbol: symbols.split(",")) {
            listQuotes.add(generateQuote(symbol));
        }
        quotes.setQuotes(listQuotes);
        return quotes;
    }

    public static Quote generateOption(String symbol, String expirationDate){
        Quote quote = new Quote();
        quote.setRootSymbol(symbol);
        quote.setExpirationDate(expirationDate);
        return quote;
    }
}
