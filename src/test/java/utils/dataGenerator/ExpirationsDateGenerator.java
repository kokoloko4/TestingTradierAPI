package utils.dataGenerator;

import lombok.Getter;

public class ExpirationsDateGenerator {

    @Getter
    private static String[] expirations = {
            "2019-09-06",
            "2019-09-13",
            "2019-09-20",
            "2019-09-27",
            "2019-10-04",
            "2019-10-11",
            "2019-10-18",
            "2019-11-15",
            "2019-12-20",
            "2020-01-17",
            "2020-02-21",
            "2020-03-20",
            "2020-04-17",
            "2020-05-15",
            "2021-01-15"
    };

    public static String[] getExpirations() {
        return expirations;
    }
}
