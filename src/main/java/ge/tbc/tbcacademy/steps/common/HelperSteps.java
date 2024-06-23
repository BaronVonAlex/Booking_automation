package ge.tbc.tbcacademy.steps.common;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.tbcacademy.data.Constants.BOOKING_URL;

public class HelperSteps {
    public HelperSteps openBookingWebPage(){
        open(BOOKING_URL);
        return this;
    }
}
