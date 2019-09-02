package utils.dataGenerator;

import entities.watchlistEntities.Item;
import entities.watchlistEntities.ItemObjects;
import entities.watchlistEntities.Watchlist;

import java.util.ArrayList;
import java.util.List;

public class WatchlistGenerator {

    public static Watchlist getWatchlist(String name, String symbols){
        Watchlist watchlist = new Watchlist();
        watchlist.setName(name);
        ItemObjects itemObjects = new ItemObjects();
        List<Item> items = new ArrayList<>();
        for (String symbol : symbols.split(",")) {
            Item item = new Item();
            item.setSymbol(symbol);
            items.add(item);
        }
        itemObjects.setItems(items);
        watchlist.setItemObjects(itemObjects);
        return watchlist;
    }

    public static Watchlist getWatchlist(String name){
        Watchlist watchlist = new Watchlist();
        watchlist.setName(name);
        return watchlist;
    }
}
