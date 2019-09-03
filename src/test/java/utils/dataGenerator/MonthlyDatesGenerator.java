package utils.dataGenerator;

import java.util.List;

public class MonthlyDatesGenerator {

    public static String[] getDates(List<String> data) {
        String dates[] = new String[data.size()-1];
        for(int i = 1; i < data.size(); i++){
            dates[i-1] = data.get(i);
        }
        return dates;
    }
}
