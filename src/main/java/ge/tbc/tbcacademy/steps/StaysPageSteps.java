package ge.tbc.tbcacademy.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ex.ElementShould;
import ge.tbc.tbcacademy.data.constants.SearchConstants;
import ge.tbc.tbcacademy.pages.StaysPage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import ge.tbc.tbcacademy.utils.Util;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.*;

public class StaysPageSteps extends HelperSteps<StaysPageSteps> {
    StaysPage staysPage = new StaysPage();

    @Step("Hover on a field where destination is inputted")
    public StaysPageSteps focusOnDestinationInput() {
        staysPage.destinationInput
                .should(exist)
                .should(appear)
                .scrollTo().hover();
        return this;
    }

    @Step("Click on a field where destination in inputted")
    public StaysPageSteps clickOnDestinationInput() {
        staysPage.destinationInput.shouldBe(clickable).click();
        return this;
    }

    @Step("Input destination {0}")
    public StaysPageSteps writeDestination(String dest) {
        staysPage.destinationInput.sendKeys(dest);

        return this;
    }

    @Step("select destination from autocomplete/autocorrect dropdown {0}")
    public StaysPageSteps selectDestinationFromDropdown(String dest) {
        staysPage.findInDestDropDown(dest).shouldBe(clickable).click();
        return this;
    }

    @Step("Make sure occupancy configuration window is open")
    public StaysPageSteps openOccupancyConfiguration() {
        staysPage.occupancyConfiguration
                .shouldBe(visible)
                .shouldBe(clickable)
                .scrollTo()
                .click();
        return this;
    }

    @Step("Click on date picker ")
    public StaysPageSteps clickOnCalendar() {
        staysPage.searchDatePicker.shouldBe(clickable).click();
        return this;
    }

    @Step("Choose Start date {0} {1} {2}")
    public StaysPageSteps chooseStartDate(String day, String month, String year) {
        while ((!staysPage.getDateFormCalendar(day, month, year).isDisplayed())
                && staysPage.nextMonthArrowBtn.isDisplayed()) {
            staysPage.nextMonthArrowBtn.click();
        }
        try {
            staysPage.getDateFormCalendar(day, month, year)
                    .shouldBe(visible).click();
        } catch (NoSuchElementException E) {
            throw new RuntimeException(SearchConstants.DATE_UNAVAILABLE);
        }

        return this;
    }

    @Step("Choose end date {0} {1} {2}")
    public StaysPageSteps chooseEndDate(String day, String month, String year) {
        while (!staysPage.getDateFormCalendar(day, month, year).isDisplayed()
                && staysPage.nextMonthArrowBtn.isDisplayed()) {
            staysPage.nextMonthArrowBtn.click();
        }
        try {
            staysPage.getDateFormCalendar(day, month, year)
                    .shouldBe(visible).click();
        } catch (NoSuchElementException E) {
            throw new RuntimeException(SearchConstants.DATE_UNAVAILABLE);
        }
        return this;
    }

    @Step("Check date picker calendar is open and croll")
    public StaysPageSteps checkCalendarIsOpen() {
        staysPage.calendar.should(exist);
        staysPage.calendar.shouldBe(visible);
        staysPage.flexibleDatesContainer.scrollIntoView(false);
        return this;
    }
    @Step("Check if Start date was correctly saved {0}")
    public StaysPageSteps checkStartDateIsSet(LocalDate start) {
        staysPage.startDate.shouldHave(partialText(Util.getShortMonthFromDate(start)));
        staysPage.startDate.shouldHave(partialText(Util.getDayOfMonth(start)));

        return this;
    }
    @Step("Check that end date was correctly saved {0}")
    public StaysPageSteps checkEndDateIsSet(LocalDate end) {
        staysPage.endDate.shouldHave(partialText(Util.getDayOfMonth(end)));
        staysPage.endDate.shouldHave(partialText(Util.getDayOfMonth(end)));

        return this;
    }
    @Step("Get Number Of Adults")
    public int getNumberOfAdults() {
        return Util.parseStringToInt(staysPage.adultsCount.getText());
    }
    @Step("Check occupancy window is open")
    public StaysPageSteps checkOccupancyConfigurationIsOpen() {
        staysPage.occupancyPopup.shouldBe(visible);
        return this;
    }
    @Step("Select number of staying Adults {0}")
    public StaysPageSteps setNumberOfAdultsTo(int numberOfAdults) {
        int adults = Util.parseStringToInt(staysPage.adultsCount.getText());
        while ((adults != numberOfAdults)) {
            if (adults > numberOfAdults) {
                try {
                    staysPage.removeAdults.shouldBe(clickable).click();
                } catch (ElementShould e) {
                    throw new RuntimeException(SearchConstants.TOO_MANY_GUESTS_MESSAGE + adults);
                }
                adults = Util.parseStringToInt(staysPage.adultsCount.getText());
            }
            if (adults < numberOfAdults) {
                try {
                    staysPage.addAdults.shouldBe(clickable).click();

                } catch (ElementShould e) {
                    throw new RuntimeException(SearchConstants.TOO_MANY_GUESTS_MESSAGE + adults);
                }
                adults = Util.parseStringToInt(staysPage.adultsCount.getText());
            }
        }

        return this;
    }
    @Step("Increase number of staying Adults")
    public StaysPageSteps addAdult() {
        staysPage.addAdults.shouldBe(clickable).click();
        return this;
    }
    @Step("Decrease number of staying Adults")
    public StaysPageSteps decreaseAdults() {
        staysPage.removeAdults.shouldBe(clickable).click();
        return this;
    }
    @Step("Increase number of staying children")
    public StaysPageSteps addChild() {
        if (!staysPage.addChild.isDisplayed() || !staysPage.addChild.isEnabled()) {
            throw new RuntimeException(SearchConstants.TOO_MANY_CHILDREN);
        }
        staysPage.addChild.shouldBe(clickable).click();
        return this;
    }
    @Step("Select child's age {0}")
    public StaysPageSteps chooseChildAge(int age) {
        if (age >= 18) {
            throw new RuntimeException(SearchConstants.NO_LONGER_CHILD);
        }
        staysPage.childAgeDropdown.shouldBe(clickable).click();
        staysPage.childAgeDropdown.selectOptionContainingText(String.valueOf(age));
        return this;
    }
    @Step("Get selected children count")
    public int getChildrenCount() {
        return Util.parseStringToInt(staysPage.childrenCount.getText());
    }
    @Step("Press On Done in Occupancy configuration")
    public StaysPageSteps submitOccupancyConfigurations() {
        if (staysPage.occupancyConfigDoneBtn.exists()) {
            staysPage.occupancyConfigDoneBtn.scrollTo().click();
        }
        return this;
    }
    @Step("Select Pet slider In Occupancy configuration")
    public StaysPageSteps addPet() {
        staysPage.withPets.shouldBe(clickable).click();
        return this;
    }
    @Step("Select Desired Number Of Rooms {0}")
    public StaysPageSteps setRoomsTo(int n) {
        while (staysPage.addRoom.isEnabled() && !staysPage.roomCount.getText().equals(String.valueOf(n))) {
            staysPage.addRoom.shouldBe(clickable).click();
        }
        if (Util.parseStringToInt(staysPage.roomCount.getText()) > n) {
            throw new RuntimeException(SearchConstants.TOO_MANY_ROOMS);
        }
        return this;
    }
    @Step("Get Number Of Rooms")
    public int getRoomCount() {
        return Util.parseStringToInt(staysPage.roomCount.getText());
    }
    @Step("Decrease number of rooms")
    public StaysPageSteps removeRoom() {
        if (staysPage.removeRoom.isEnabled()) {
            staysPage.removeRoom.shouldBe(clickable).click();
        } else {
            throw new RuntimeException(SearchConstants.NO_ROOM_TO_REMOVE + staysPage.roomCount.getText());
        }

        return this;
    }
    @Step("Click on search button")
    public StaysPageSteps clickOnSearchButton() {
        staysPage.searchButton.scrollTo().shouldBe(clickable).click();
        return this;
    }
    @Step("Make Sure search results are displayed")
    public StaysPageSteps checkSearchResultsAreReady() {
        staysPage.searchResult.should(appear);
        return this;
    }

    @Step("Check that all results are on selected location {0}")
    public StaysPageSteps offerLocationCheck(String dest) {
        staysPage.offerLocations.shouldHave(CollectionCondition.allMatch(
                "All are located to the same city",
                e -> {
                    return e.getText().contains(dest);
                }
        ));
        return this;
    }
    @Step("Check that all results are fulfilling occupancy configurations {0} {1} {2}")
    public StaysPageSteps offersSatisfyConfigs(int adults, int children, int days) {
        staysPage.occupancyConfigs.shouldHave(CollectionCondition.allMatch(
                "Occupancy configs are set",
                e -> {
                    return e.getText().contains(Util.getOccupancyString(adults,children,days));
                }
        ));
        return this;
    }

}
