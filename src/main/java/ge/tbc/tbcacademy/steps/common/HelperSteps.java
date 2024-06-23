package ge.tbc.tbcacademy.steps.common;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.tbcacademy.data.Constants.BOOKING_URL;

public class HelperSteps {
    public static void openBookingWebPage(){
        open(BOOKING_URL);
    }
}
