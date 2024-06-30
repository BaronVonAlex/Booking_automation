package ge.tbc.tbcacademy.steps;

import ge.tbc.tbcacademy.pages.FlightsPage;
import io.qameta.allure.Step;

public class FlightsPageSteps {
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
}
