package ge.tbc.tbcacademy.utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.webdriver;

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

    /**
     * Get abbreviated month name form LocalDate
     **/
    public static String getShortMonthFromDate(LocalDate date) {
        return date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }

    /**
     * Get full week day name form LocalDate
     **/
    public static String getLongWeekDayFromDate(LocalDate date) {
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    /**
     * Get abbreviated week day form LocalDate
     **/
    public static String getShortWeekDayFromDate(LocalDate date) {
        return date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }

    /**
     * Get day of the month form LocalDate
     **/
    public static String getDayOfMonth(LocalDate date) {
        return String.valueOf(date.getDayOfMonth());
    }

    /**
     * Get year from LocalDate
     **/
    public static String getYear(LocalDate date) {
        return String.valueOf(date.getYear());
    }

    /**
     * Get occupancy configuration value from given parameters
     **/
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


    /**
     * Calculates the relative luminance of a color.
     *
     * @param color The color.
     * @return The relative luminance of the color.
     */
    private static double calculateRelativeLuminance(Color color) {
        double sRGB = color.getColor().getRed();
        return sRGB <= 0.03928 ? sRGB / 12.92 : Math.pow((sRGB + 0.055) / 1.055, 2.4);
    }

    /**
     * Calculates the contrast ratio between two colors.
     *
     * @param color1 The first color.
     * @param color2 The second color.
     * @return The contrast ratio between the two colors.
     */
    public static double calculateContrastRatio(Color color1, Color color2) {
        double L1 = calculateRelativeLuminance(color1);
        double L2 = calculateRelativeLuminance(color2);
        return (Math.max(L1, L2) + 0.05) / (Math.min(L1, L2) + 0.05);
    }

    /**
     * Checks if the contrast ratio between two colors meets WCAG guidelines.
     */
    public static boolean meetsWCAGGuidelines(Color color1, Color color2, String level) {
        double ratio = calculateContrastRatio(color1, color2);
        if (level.equalsIgnoreCase("AA")) {
            return ratio >= 4.5;
        } else if (level.equalsIgnoreCase("AAA")) {
            return ratio >= 7.0;
        } else {
            throw new IllegalArgumentException("Invalid WCAG level: " + level);
        }
    }

    public static String getPseudoElementStyle(SelenideElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webdriver().object();
        return (String) js.executeScript(
                "return window.getComputedStyle(arguments[0], arguments[1]).getPropertyValue(arguments[2]);",
                element, "::before", "background-color");
    }
}
