package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.watchlistEntities.Watchlist;
import entities.watchlistEntities.ResultWatchlists;
import entities.watchlistEntities.Watchlists;
import io.restassured.response.Response;
import utils.RequestFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static modules.APIModule.WATCHLISTS;
import static submodules.APISubmodule.*;

public class WatchlistsHelper {

    public static Watchlist createWatchlist(String name, String symbols){
        Map<String, String> bodyParams = new HashMap<>();
        bodyParams.put("name", name);
        bodyParams.put("symbols", symbols);
        Response response = new RequestFactory().createRequest("POST", WATCHLISTS, WL_CREATE,
                null, bodyParams);
        ObjectMapper mapper = new ObjectMapper();
         Watchlist watchlist = null;
        try {
            watchlist = mapper.readValue(response.getBody().asString(), Watchlist.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return watchlist;
    }

    public static Watchlists getWatchlists(){
        Response response = new RequestFactory().createRequest("GET", WATCHLISTS, WL_ALL,
                null, null);
        ObjectMapper mapper = new ObjectMapper();
        ResultWatchlists watchlists = null;
        try {
            watchlists = mapper.readValue(response.getBody().asString(), ResultWatchlists.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return watchlists.getWatchlists();
    }

    public static Watchlist getOneWatchlist(String id){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("watchlist_id", id);
        Response response = new RequestFactory().createRequest("GET", WATCHLISTS, WL_ONE,
                queryParams, null);
        ObjectMapper mapper = new ObjectMapper();
        Watchlist watchlist = null;
        try {
            watchlist = mapper.readValue(response.getBody().asString(), Watchlist.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return watchlist;
    }

    public static Watchlist updateWatchList(String name, String id){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("watchlist_id", id);
        Map<String, String> requestBody = new HashMap<>();
        queryParams.put("name", name);
        Response response = new RequestFactory().createRequest("PUT", WATCHLISTS, WL_UPDATE,
                queryParams, requestBody);
        ObjectMapper mapper = new ObjectMapper();
        Watchlist watchlist = null;
        try {
            watchlist = mapper.readValue(response.getBody().asString(), Watchlist.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return watchlist;
    }

    public static Watchlist deleteWatchList(String id){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("watchlist_id", id);
        Response response = new RequestFactory().createRequest("DELETE", WATCHLISTS, WL_DELETE,
                queryParams, null);
        ObjectMapper mapper = new ObjectMapper();
        Watchlist watchlist = null;
        try {
            watchlist = mapper.readValue(response.getBody().asString(), Watchlist.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return watchlist;
    }

    public static Watchlist addSymbols(String id, String symbols){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("watchlist_id", id);
        Map<String, String> requestBody = new HashMap<>();
        queryParams.put("symbols", symbols);
        Response response = new RequestFactory().createRequest("GET", WATCHLISTS, WL_ADD_SYMBOLS,
                queryParams, requestBody);
        ObjectMapper mapper = new ObjectMapper();
        Watchlist watchlist = null;
        try {
            watchlist = mapper.readValue(response.getBody().asString(), Watchlist.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return watchlist;
    }

    public static Watchlist deleteSymbolWatchList(String id, String symbol){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("watchlist_id", id);
        queryParams.put("symbol", symbol);
        Response response = new RequestFactory().createRequest("DELETE", WATCHLISTS, WL_REMOVE_SYMBOL,
                queryParams, null);
        ObjectMapper mapper = new ObjectMapper();
        Watchlist watchlist = null;
        try {
            watchlist = mapper.readValue(response.getBody().asString(), Watchlist.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return watchlist;
    }

    public static boolean validateDelSymbol(Watchlist watchlist, Watchlist watchlistResponse){
        boolean match = true;
        int cont = 0;
        while(cont < watchlistResponse.getItemObjects().getItems().size() && match){
            if(watchlistResponse.getItemObjects().getItems().get(cont).getSymbol()
                    .equals(watchlist.getItemObjects().getItems().get(cont).getSymbol())){
                match = false;
            }
            cont++;
        }
        return match;
    }

    public static boolean validateNewSymbols(Watchlist watchlist, Watchlist watchlistResponse){
        boolean match = true;
        int cont = 0;
        while(cont < watchlistResponse.getItemObjects().getItems().size() && match){
            if(!watchlistResponse.getItemObjects().getItems().get(cont).getSymbol()
                    .equals(watchlist.getItemObjects().getItems().get(cont).getSymbol())){
                match = false;
            }
            cont++;
        }
        return match;
    }

    public static boolean validateSpecWatchlist(Watchlist watchlist, Watchlist watchlistResponse){
        if(!watchlist.getName().equals(watchlistResponse.getName())){
            return false;
        }
        return true;
    }

    public static boolean validateWatchlist(Watchlist watchlist, Watchlists watchlists){
        boolean match = true;
        if(watchlists.getWatchlistList().size() > 0){
            int cont = 0;
            while(cont < watchlists.getWatchlistList().size() && match){
                if(!watchlists.getWatchlistList().get(cont).getName().equals(watchlist.getName())){
                    match = false;
                }
                cont++;
            }
        }else{
            match = false;
        }
        return match;
    }

    public static boolean validateNewWatclist(Watchlist watchlist, Watchlist newWatchlist){
        boolean match = true;
        if(watchlist.getName().equals(newWatchlist.getName())){
            if(watchlist.getItemObjects().getItems().size() == newWatchlist.getItemObjects().getItems().size()){
                int cont = 0;
                while(cont < newWatchlist.getItemObjects().getItems().size() && match){
                    if(!newWatchlist.getItemObjects().getItems().get(cont).getSymbol().equals(watchlist
                            .getItemObjects().getItems().get(cont).getSymbol())){
                        match = false;
                    }
                    cont++;
                }
            }else{
                match = false;
            }
        }else{
            match = false;
        }
        return match;
    }
}
