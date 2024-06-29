package ge.tbc.tbcacademy.utils;

import com.codeborne.selenide.SelenideElement;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

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

    /**
     * Generates an HTML accessibility report using the Axe-core analysis results.
     *
     * @param axeResults The data containing the accessibility violations.
     * @throws IOException If an error occurs during report generation.
     */
    public static void generateReport(Map<String, Object> axeResults) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setClassForTemplateLoading(Util.class, "/");
        Template template = cfg.getTemplate("accessibility_report.ftl");

        // Extract Summary Information
        int violationCount = ((List<Map<String, Object>>) axeResults.get("violations")).size();
        int totalNodes = ((List<Map<String, Object>>) axeResults.get("violations")).stream()
                .mapToInt(v -> ((List<Map<String, Object>>) v.get("nodes")).size())
                .sum();

        // Prepare data for the template
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("axeResults", axeResults);
        templateData.put("violationCount", violationCount);
        templateData.put("totalNodes", totalNodes);
        templateData.put("timestamp", new Date());

        // Before writing the file check if directory doesnt exists:
        File directory = new File("axe-core");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Generate the report
        try (Writer fileWriter = new FileWriter("axe-core/accessibility_report.html")) {
            template.process(templateData, fileWriter);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
