package ge.tbc.tbcacademy.utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.webdriver;

public class Util {
    public static String getPseudoElementStyle(SelenideElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webdriver().object();
        return (String) js.executeScript(
                "return window.getComputedStyle(arguments[0], arguments[1]).getPropertyValue(arguments[2]);",
                element, "::before", "background-color");
    }

//    public static String getBackgroundColor(SelenideElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) webdriver().object();
//        return (String) js.executeScript("return window.getComputedStyle(arguments[0]).getPropertyValue('background-color');", element);
//    }
}
