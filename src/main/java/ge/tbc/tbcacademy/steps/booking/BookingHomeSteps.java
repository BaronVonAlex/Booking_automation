package ge.tbc.tbcacademy.steps.booking;

import ge.tbc.tbcacademy.pages.BookingHomePage;
import io.qameta.allure.Step;

public class BookingHomeSteps {
    BookingHomePage bookingHomePage = new BookingHomePage();

    @Step("If Login or Register Dialog pop-up exists click on X Button, else continue.")
    public BookingHomeSteps checkIfDialogIsOpen(){
        if (bookingHomePage.signInOrRegisterDialogPopup.exists()){
            return this;
        }
        return this; // temporary
    }

    @Step("Validate that Homepage loads successfully.")
    public String validateIfHomePageIsLoaded() {
        return bookingHomePage.bookingHomeHeader.getAttribute("aria-label");
    }

    @Step("Click on Register button.")
    public BookingHomeSteps clickOnRegisterBtn() {
        bookingHomePage.registerBtn.click();
        return this;
    }

    @Step("Validate that Account was created.")
    public String validateIfAccountWasCreated() {
        return bookingHomePage.welcomeUserPopupMsg.getText();
    }

    @Step("Close Welcome Pop-up window")
    public BookingHomeSteps clickOnGotItButton() {
        bookingHomePage.welcomePopUpAcceptBtn.click();
        return this;
    }
}
