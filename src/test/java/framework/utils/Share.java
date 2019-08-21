package framework.utils;

import java.util.HashMap;
import java.util.Map;

public class Share {

    private static ThreadLocal<Map<String,Object>> shareMaps = ThreadLocal.withInitial(HashMap::new);

    public Share() {
    }

    public static void setShare(String key, Object value){
        ((Map)shareMaps.get()).put(key, value);
    }

    public static void setShare(Class key, Object value){
        ((Map)shareMaps.get()).put(key.getName(), value);
    }

    public static <T> T getShare(String key){
        return (T) ((Map)shareMaps.get()).get(key);
    }

    public static <T> T getShare(Class key){
        return (T) ((Map)shareMaps.get()).get(key.getName());
    }
}
