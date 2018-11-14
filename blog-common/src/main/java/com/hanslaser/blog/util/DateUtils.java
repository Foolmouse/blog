package com.hanslaser.blog.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * 日期时间工具类.
 *
 * @author shengtao.zhou
 * @since 2018.06.13
 */
public class DateUtils {

    public static String formatDate(Timestamp date) {
        return date == null ? "" : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String formatDate(Date date) {
        String returnStr = "";

        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            returnStr = sdf.format(date);
        }

        return returnStr;
    }

    public static String formatNowDate(String pattern) {
        return formatDate(pattern, new Date());
    }

    public static String formatDate(String pattern, Date date) {
        String returnStr = "";

        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            returnStr = sdf.format(date);
        }

        return returnStr;
    }

    public static String getCurrentDateAs19() {
        return formatDate(new Date(System.currentTimeMillis()));
    }

    public static String formatDateAsYYYYMMDD(Date date) {
        String returnStr = "";

        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            returnStr = sdf.format(date);
        }

        return returnStr;
    }

    @SuppressWarnings("deprecation")
    public static java.sql.Date getSQLDateAsYYYYMMDD(Date date) {
        if (date != null) {
            return new java.sql.Date(date.getYear(), date.getMonth(), date.getDate());
        }

        return null;
    }

    public static int compareDate(Date date1, Date date2) {
        date1 = getDateAsYYYYMMDD(date1);
        date2 = getDateAsYYYYMMDD(date2);

        if (date1.getTime() == date2.getTime()) {
            return 0;
        } else if (date1.getTime() > date2.getTime()) {
            return 1;
        } else {
            return -1;
        }
    }

    public static String getCurrentAsYYYYMMDDHHString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        return sdf.format(new Date());
    }

    public static String getTimestampString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    @SuppressWarnings("deprecation")
    public static Date getDateAsYYYYMMDD(Date date) {
        if (date != null) {
            return new Date(date.getYear(), date.getMonth(), date.getDate());
        }

        return null;
    }

    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp getTimestamp(String date) {
        try {
            return Timestamp.valueOf(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static java.sql.Date toSqlDate(Date date) {
        if (date == null) {
            return null;
        }

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        return sqlDate;
    }

    public static Date toDate(java.sql.Date date) {
        if (date == null) {
            return null;
        }

        Date newDate = new Date(date.getTime());

        return newDate;
    }

    public static java.sql.Date toSqlDate(LocalDate date) {
        if (date == null) {
            return null;
        }

        ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.systemDefault());

        return toSqlDate(java.sql.Date.from(zonedDateTime.toInstant()));
    }

    public static LocalDate toLocalDate(java.sql.Date date) {
        if (date == null) {
            return null;
        }

        Instant instant = toDate(date).toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();

        return localDate;
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);

        return localDateTime;
    }

    public static LocalDate toLocalDate(Date date) {
        if (date == null) {
            return null;
        }

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();

        return localDate;
    }

    /**
     * 日期转化 毫秒转化成 XXX天XX时XX分XX秒
     */
    public static String getDateDayHourMinuteSecond(long seconds){
        seconds = seconds/1000;
        int day=(int)(seconds/(24 * 60 * 60));//换成天
        int hour=(int)((seconds - day * 24 * 60 * 60)/3600);
        int minute=(int)((seconds - day * 24 * 60 * 60 - hour * 60 * 60)/60);
        int second=(int)(seconds - day * 24 * 60 * 60 - hour * 60 * 60 - minute * 60);
        return day+"天"+hour+"时"+minute+"分"+second+"秒";
    }
}
