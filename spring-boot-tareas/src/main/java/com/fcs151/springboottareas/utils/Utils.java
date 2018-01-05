package com.fcs151.springboottareas.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static final String BAD_PARAMETER_CODE = "1";
    public static final String DATETIME_PATTERN_MELI_CHARGE = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_PATTERN_MELI_CHARGE);
    
    public static String getFormatDate(Date dateTime) {
        return sdf.format(dateTime);
    }
}
