package ge.tbc.tbcacademy.booking;

import ge.tbc.tbcacademy.booking.config.ConfigTests;
import ge.tbc.tbcacademy.steps.FlightsPageSteps;
import ge.tbc.tbcacademy.steps.KayakPageSteps;
import ge.tbc.tbcacademy.steps.MainPageSteps;
import ge.tbc.tbcacademy.steps.common.HeaderSectionSteps;
import ge.tbc.tbcacademy.utils.Util;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static ge.tbc.tbcacademy.data.constants.Constants.DESTINATION_CITY;
import static ge.tbc.tbcacademy.data.constants.Constants.FLIGHTS;

@Epic("Booking Website Functionality")
public class FlightsTests extends ConfigTests {
    HeaderSectionSteps headerSectionSteps;
    MainPageSteps mainPageSteps;
    FlightsPageSteps flightsPageSteps;
    KayakPageSteps kayakPageSteps;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        headerSectionSteps = new HeaderSectionSteps();
        mainPageSteps = new MainPageSteps();
        flightsPageSteps = new FlightsPageSteps();
        kayakPageSteps = new KayakPageSteps();
        mainPageSteps.openBookingWebPage();
    }

    @Test(description = "Verify flight search, sorting, and deal click.")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Flights Search Functionality")
    @Story("Sort by Price and Deal Click")
    @Description("Verify that flight search results are sorted by price and that clicking a deal opens a new window.")
    public void flightTests() {
        mainPageSteps.closeSignInPopUp();
        headerSectionSteps.clickNavItemByText(FLIGHTS);
        flightsPageSteps
                .typeFinalDestination(DESTINATION_CITY)
                .clickOnFirstSuggestion()
                .clickOnReturnDropDown()
                .chooseOneWayOption()
                .clickSearchButton();

        kayakPageSteps
                .checkAirlinesOnlyCheckBox()
                .clickCheapestButton()
                .waitForComponentLoad();

        List<Integer> prices = kayakPageSteps.getPrices();

        Assert.assertTrue(Util.isSorted(prices));

        kayakPageSteps
                .clickFirstDeal()
                .validateThatNewWindowOpened();
    }
}
