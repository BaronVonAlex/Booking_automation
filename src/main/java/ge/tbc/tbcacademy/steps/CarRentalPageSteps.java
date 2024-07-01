package ge.tbc.tbcacademy.steps;

import ge.tbc.tbcacademy.pages.CarRentalPage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import io.qameta.allure.Step;

import static ge.tbc.tbcacademy.data.constants.UIConstants.*;

public class CarRentalPageSteps extends HelperSteps<CarRentalPageSteps> {
    CarRentalPage carRentalPage = new CarRentalPage();

    @Step("Validate if pick-up location div exists")
    public CarRentalPageSteps validatePickUpLocationDivExists() {
        validateIfElementExists(carRentalPage.pickUpLocationDiv);
        return this;
    }

    @Step("Validate if pick-up date button exists")
    public CarRentalPageSteps validatePickUpDateButtonExists() {
        validateIfElementExists(carRentalPage.pickUpDateButton);
        return this;
    }

    @Step("Validate if pick-up date select exists")
    public CarRentalPageSteps validatePickUpDateSelectExists() {
        validateIfElementExists(carRentalPage.pickUpDateSelect);
        return this;
    }

    @Step("Validate if drop-off date exists")
    public CarRentalPageSteps validateDropOffDateExists() {
        validateIfElementExists(carRentalPage.dropOffDate);
        return this;
    }

    @Step("Validate if drop-off time exists")
    public CarRentalPageSteps validateDropOffTimeExists() {
        validateIfElementExists(carRentalPage.dropOffTime);
        return this;
    }

    @Step("Validate if search button exists")
    public CarRentalPageSteps validateSearchButtonExists() {
        validateIfElementExists(carRentalPage.searchButton);
        return this;
    }

    @Step("Validate if supplier list exists")
    public CarRentalPageSteps validateSupplierListExists() {
        validateIfElementExists(carRentalPage.supplierList);
        return this;
    }

    @Step("Validate if FAQs list exists")
    public CarRentalPageSteps validateFaqsListExists() {
        validateIfElementExists(carRentalPage.faqsList);
        return this;
    }

    @Step("Validate if footer exists")
    public CarRentalPageSteps validateFooterExists() {
        validateIfElementExists(carRentalPage.footer);
        return this;
    }

    @Step("Validate if footer top menu exists")
    public CarRentalPageSteps validateFooterTopMenuExists() {
        validateIfElementExists(carRentalPage.footerTopMenu);
        return this;
    }

    @Step("Validate pick-up date button color")
    public CarRentalPageSteps validatePickUpDateButtonColor() {
        validateElementColor(carRentalPage.pickUpDateButton, PICKUP_BTN_CLR);
        return this;
    }

    @Step("Validate car rental header text")
    public CarRentalPageSteps validateCarRentalHeaderText() {
        validateElementTextAnyOf(carRentalPage.carRentalHeader, CAR_RENTAL_HEADER_TEXT, CAR_RENTAL_HEADER_TEXT_SECOND_VARIANT);
        return this;
    }

    @Step("Validate search button text")
    public CarRentalPageSteps validateSearchButtonText() {
        validateElementText(carRentalPage.searchButton, SEARCH_BUTTON_TEXT);
        return this;
    }

    @Step("Validate pick-up location text value")
    public CarRentalPageSteps validatePickUpLocationTextValue() {
        validateElementValue(carRentalPage.pickupLocationTxt, ATTRIBUTE_FOR, PICK_UP_LOCATION_VAL);
        return this;
    }
}
