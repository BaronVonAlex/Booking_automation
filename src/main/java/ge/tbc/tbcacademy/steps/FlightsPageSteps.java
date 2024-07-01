package ge.tbc.tbcacademy.steps;

import ge.tbc.tbcacademy.pages.FlightsPage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import io.qameta.allure.Step;

import static ge.tbc.tbcacademy.data.constants.UIConstants.*;

public class FlightsPageSteps extends HelperSteps<FlightsPageSteps> {
    FlightsPage flightsPage = new FlightsPage();


    @Step("Enter '{0}' as the final destination in the search field")
    public FlightsPageSteps typeFinalDestination(String destination) {
        flightsPage.destinationInput.sendKeys(destination);
        return this;
    }

    @Step("Click on the first destination suggestion from the dropdown")
    public FlightsPageSteps clickOnFirstSuggestion() {
        flightsPage.firstDestinationSuggestion.click();
        return this;
    }

    @Step("Click the 'Search' button to initiate the flight search")
    public FlightsPageSteps clickSearchButton() {
        flightsPage.searchButton.click();
        return this;
    }

    @Step("Click the 'Return' dropdown to select a return date")
    public FlightsPageSteps clickOnReturnDropDown() {
        flightsPage.returnDropDown.click();
        return this;
    }

    @Step("Select the 'One Way' option for a one-way trip")
    public FlightsPageSteps chooseOneWayOption() {
        flightsPage.oneWayOption.click();
        return this;
    }

    @Step("Validate if form section exists")
    public FlightsPageSteps validateFormSectionExists() {
        validateIfElementExists(flightsPage.formSection);
        return this;
    }

    @Step("Validate if destination from field exists")
    public FlightsPageSteps validateDestinationFromExists() {
        validateIfElementExists(flightsPage.destinationFrom);
        return this;
    }

    @Step("Validate if switch destinations button exists")
    public FlightsPageSteps validateSwitchDestinationsButtonExists() {
        validateIfElementExists(flightsPage.switchDestinationsButton);
        return this;
    }

    @Step("Validate if destination to field exists")
    public FlightsPageSteps validateDestinationToExists() {
        validateIfElementExists(flightsPage.destinationTo);
        return this;
    }

    @Step("Validate if dates field exists")
    public FlightsPageSteps validateDatesFieldExists() {
        validateIfElementExists(flightsPage.datesField);
        return this;
    }

    @Step("Validate if submit button exists")
    public FlightsPageSteps validateSubmitButtonExists() {
        validateIfElementExists(flightsPage.submitButton);
        return this;
    }

    @Step("Validate if language button exists")
    public FlightsPageSteps validateLanguageButtonExists() {
        validateIfElementExists(flightsPage.languageBtn);
        return this;
    }

    @Step("Validate if currency button exists")
    public FlightsPageSteps validateCurrencyButtonExists() {
        validateIfElementExists(flightsPage.currencyBtn);
        return this;
    }

    @Step("Validate header background color")
    public FlightsPageSteps validateHeaderBackgroundColor() {
        validateElementColor(flightsPage.headerBackground, HEADER_BACKGROUND_COLOR);
        return this;
    }

    @Step("Validate submit button color")
    public FlightsPageSteps validateSubmitButtonColor() {
        validateElementColor(flightsPage.submitBtnColor, SUBMIT_BUTTON_COLOR);
        return this;
    }

    @Step("Validate background div color")
    public FlightsPageSteps validateBackgroundDivColor() {
        validateElementColor(flightsPage.backgroundDiv, BACKGROUND_DIV_COLOR);
        return this;
    }

    @Step("Validate flights title text")
    public FlightsPageSteps validateFlightsTitleText() {
        validateElementTextAnyOf(flightsPage.flightsTitle, FLIGHTS_TITLE_TEXT, FLIGHTS_TITLE_TEXT_SECOND_VARIANT);
        return this;
    }

    @Step("Validate submit button text")
    public FlightsPageSteps validateSubmitButtonText() {
        validateElementText(flightsPage.submitButtonText, SUBMIT_BUTTON_TEXT);
        return this;
    }

    @Step("Validate origin place text")
    public FlightsPageSteps validateOriginPlaceText() {
        validateElementText(flightsPage.originPlace, ORIGIN_PLACE_TEXT);
        return this;
    }

    @Step("Validate destination from field placeholder")
    public FlightsPageSteps validateDestinationFromPlaceholder() {
        validateElementValue(flightsPage.destinationFromText, ATTRIBUTE_PLACEHOLDER, DESTINATION_FROM_PLACEHOLDER);
        return this;
    }

    @Step("Validate destination to field placeholder")
    public FlightsPageSteps validateDestinationToPlaceholder() {
        validateElementValue(flightsPage.destinationInput, ATTRIBUTE_PLACEHOLDER, DESTINATION_TO_PLACEHOLDER);
        return this;
    }
}
