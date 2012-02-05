package org.voelk.holidays.web.util;

import java.text.*;
import java.util.*;

public class DateUtils {

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    public static Date convertStringToDate(String date) {
        try {
            return new SimpleDateFormat(DATE_PATTERN).parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("The provided dates have an unexpected format: %s. Expected format is %s", date, DATE_PATTERN), e);
        }
    }
}
