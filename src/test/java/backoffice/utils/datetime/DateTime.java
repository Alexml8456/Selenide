package backoffice.utils.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTime {
    public static String returnCurrentDate() {
        return DateTimeFormatter.ofPattern("dd/MM/yyy").format(LocalDate.now());
    }
}