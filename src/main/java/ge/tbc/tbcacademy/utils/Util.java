package ge.tbc.tbcacademy.utils;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Util {
    /**
     * concatenated the date arts to whole date
     **/
    public static String getCalendarFormatDate(String day, String month, String year) {
        return day + " " + month + " " + year;
    }

    /**
     * String to int
     **/
    public static int parseStringToInt(String str) {
        return Integer.parseInt(str);
    }

    /**
     * Get full month name form LocalDate
     **/
    public static String getLongMonthFromDate(LocalDate date) {
        return date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
    /** Get abbreviated month name form LocalDate**/
    public static String getShortMonthFromDate(LocalDate date) {
        return date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }
    /** Get full week day name form LocalDate**/
    public static String getLongWeekDayFromDate(LocalDate date) {
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
    /** Get abbreviated week day form LocalDate**/
    public static String getShortWeekDayFromDate(LocalDate date) {
        return date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }
    /** Get day of the month form LocalDate**/
    public static String getDayOfMonth(LocalDate date) {
        return String.valueOf(date.getDayOfMonth());
    }
    /** Get year from LocalDate**/
    public static String getYear(LocalDate date) {
        return String.valueOf(date.getYear());
    }
    /** Get occupancy configuration value from given parameters **/
    public static String getOccupancyString(int adults, int children, int days) {
        //4 nights, 3 adults, 1 child
        if (children == 0) {
            if (days % 7 == 0) {
                return String.format("%d week, %d adults", days / 7, adults);
            } else {
                return String.format("%d nights, %d adults", days, adults);
            }
        } else {
            if (days % 7 == 0) {
                return String.format("%d week, %d adults, %d child", days / 7, adults, children);
            } else {
                return String.format("%d nights, %d adults, %d child", days, adults, children);
            }

        }
    }
}
