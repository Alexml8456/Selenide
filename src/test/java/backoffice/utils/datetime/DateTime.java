package backoffice.utils.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTime {
    public static String getCurrentDate() {
        return DateTimeFormatter.ofPattern("dd/MM/yyy").format(LocalDate.now());
    }

    public static int getCurrentYear() {
        return Integer.parseInt(DateTimeFormatter.ofPattern("yyy").format(LocalDate.now()));
    }

}