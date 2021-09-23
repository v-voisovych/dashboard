package com.rogers.dashboard.utill;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TimestampUtil {
    public static String timeNow() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss.SSS"));
//        return LocalDateTime.now().toString();
        return ZonedDateTime.now().toString();
    }

    public static long duration(String localDateTimeStart, String localDateTimeFinish) {
        ZonedDateTime start = ZonedDateTime.parse(localDateTimeStart);
        ZonedDateTime finish = ZonedDateTime.parse(localDateTimeFinish);
        return start.until(finish, ChronoUnit.MILLIS);
    }
}