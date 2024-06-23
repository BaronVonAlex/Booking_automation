package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BookingHomePage {
    public SelenideElement
        bookingHomeHeader = $x("//a[@data-testid='header-booking-logo']"),
        registerBtn = $x("//a[@data-testid='header-sign-up-button']"),
        loginBtn = $x("//a[@data-testid='header-sign-in-button']"),
        // Registration Success, Welcome Pop-up Window.
        welcomeUserPopupMsg = $("h2[id$='-title'] strong"),
        welcomePopUpAcceptBtn = $x("//span[contains(text(), 'Got it!')]"),
        signInOrRegisterDialogPopup = $x("//div[@role='dialog']");
}
