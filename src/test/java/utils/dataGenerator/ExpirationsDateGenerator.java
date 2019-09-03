package utils.dataGenerator;

import lombok.Getter;

import java.util.List;

public class ExpirationsDateGenerator {

    public static String[] getExpirations(List<String> data) {
        String dates[] = new String[data.size()-1];
        for(int i = 1; i < data.size(); i++){
            dates[i-1] = data.get(i);
        }
        return dates;
    }
}
