package ge.tbc.tbcacademy.steps.common;

import ge.tbc.tbcacademy.pages.HomePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.tbcacademy.data.Constants.BOOKING_URL;
import static ge.tbc.tbcacademy.data.JSScripts.REMOVE_DIALOG_ELEMENT_SCRIPT;

public class HelperSteps<T> {

    HomePage homePage = new HomePage();

    @Step("Open Booking.com Webpage.")
    public T openBookingWebPage() {
        open(BOOKING_URL);

        return (T) this;
    }

    @Step("Close Login/Register Prompt Popup.")
    public T closeSignInPopUp() {
        executeJavaScript(REMOVE_DIALOG_ELEMENT_SCRIPT);

        if (homePage.dialogXBtn.is(visible)) {
            homePage.dialogXBtn.click();
            homePage.dialogXBtn.should(disappear);
        }
        return (T) this;
    }
}
