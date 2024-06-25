package ge.tbc.tbcacademy.utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * In this class there are functions that can be reused in several pages
 **/
public class CommonElementPicker {


    /**
     * Finds Date element from calendar table can be reused
     **/
    public SelenideElement getCalendarCellByDate(String day, String month, String year) {

        String date = Util.getCalendarFormatDate(day, month, year);
        return $("[aria-label='"+date+"']");
    }
}
