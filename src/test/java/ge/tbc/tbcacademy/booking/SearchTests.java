package ge.tbc.tbcacademy.booking;

import com.codeborne.selenide.Configuration;
import ge.tbc.tbcacademy.booking.config.ConfigTests;
import ge.tbc.tbcacademy.data.dataproviders.TripDataProvider;
import ge.tbc.tbcacademy.steps.StaysPageSteps;
import ge.tbc.tbcacademy.utils.Util;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.Random;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static ge.tbc.tbcacademy.data.constants.SearchConstants.*;

@Epic("Functional Tests")
public class SearchTests extends ConfigTests {
    StaysPageSteps staysSteps = new StaysPageSteps();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void dismissPopups() {
        staysSteps.openBookingWebPage()
                .closeSignInPopUp();
    }

    @Description("choose destination in the search bar and check sugestion")
    @Feature("Search bar functionality")
    @Story("input text in destination and choose completion form autosuggest")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = "Search Bar Components", dataProvider = "destinationProvider", dataProviderClass = TripDataProvider.class)
    public void chooseDestination(String dest) {
        staysSteps.focusOnDestinationInput()
                .clickOnDestinationInput()
                .writeDestination(dest)
                .selectDestinationFromDropdown(dest);
    }

    @Description("Add Adults into configs")
    @Feature("Search bar functionality")
    @Story("Add number of adults that that will be staying")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = "Search Bar Components", dataProvider = "adultsCountProvider", dataProviderClass = TripDataProvider.class)
    public void addingAdultsTests(int adults) {
        int currentNumberOfAdults = staysSteps.openOccupancyConfiguration()
                .checkOccupancyConfigurationIsOpen()
                .setNumberOfAdultsTo(adults)
                .getNumberOfAdults();

        softAssert.assertEquals(currentNumberOfAdults, adults,
                ADULT_OCCUPANT_ERR_MSG);
        staysSteps.submitOccupancyConfigurations();

    }

    @Description("Add children ")
    @Feature("Search bar functionality")
    @Story("add number of children in the configurations")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = "Search Bar Components", dataProvider = "childCountProvider", dataProviderClass = TripDataProvider.class)
    public void addChildrenTest(int children, int age) {
        staysSteps.openOccupancyConfiguration()
                .checkOccupancyConfigurationIsOpen();
        for (int i = 0; i < children; i++) {
            Random rand = new Random();
            staysSteps.addChild()
                    .chooseChildAge(age);
        }
        int currentNumberOfChildren = staysSteps.getChildrenCount();
        Assert.assertEquals(currentNumberOfChildren, children, CHILDREN_NUMBER_ERR_MSG);
        staysSteps.submitOccupancyConfigurations();

    }

    @Description("Choose Dates from calendar date picker")
    @Feature("Search bar functionality")
    @Story("Choose trip start and end date from calendar")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = "Search Bar Components", dataProvider = "datesProvider", dataProviderClass = TripDataProvider.class)
    public void chooseDatesTests(LocalDate startDate, LocalDate endDate) {

        String startDay = Util.getDayOfMonth(startDate);
        String startMonth = Util.getLongMonthFromDate(startDate);
        String startYear = Util.getYear(startDate);
        String endDay = Util.getDayOfMonth(endDate);
        String endMonth = Util.getLongMonthFromDate(endDate);
        String endYear = Util.getYear(endDate);

        staysSteps.clickOnCalendar()
                .checkCalendarIsOpen()
                .chooseStartDate(startDay, startMonth, startYear)
                .chooseEndDate(endDay, endMonth, endYear)
                .clickOnCalendar()
                .checkEndDateIsSet(endDate)
                .checkStartDateIsSet(startDate);

    }

    @Description("Choose desired number of rooms")
    @Feature("Search bar functionality")
    @Story("Choose desired number of rooms form the occupancy configurations")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = "Search Bar Components")
    public void chooseRoomNumber() {
        int n = 4;
        staysSteps.openOccupancyConfiguration()
                .checkOccupancyConfigurationIsOpen()
                .setRoomsTo(n);
        Assert.assertEquals(staysSteps.getRoomCount(), n, ROOMS_MISMATCH_ERR_MSG);
        staysSteps.submitOccupancyConfigurations();
    }

    @Description("on stays page enter parameters and searchfor stays")
    @Feature("Search bar functionality")
    @Story("On stays page enter location, date, and number of guests and search for results")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "searchInfoProvider", dataProviderClass = TripDataProvider.class)
    public void searchScenarioTest(String dest, LocalDate startDate, int tripDuration, int adults, int rooms, int children) {
        LocalDate endDate = startDate.plusDays(tripDuration);
        String startDay = Util.getDayOfMonth(startDate);
        String startMonth = Util.getLongMonthFromDate(startDate);
        String startYear = Util.getYear(startDate);
        String endDay = Util.getDayOfMonth(endDate);
        String endMonth = Util.getLongMonthFromDate(endDate);
        String endYear = Util.getYear(endDate);

        staysSteps
                .clickOnDestinationInput()
                .writeDestination(dest)
                .selectDestinationFromDropdown(dest)
                .checkCalendarIsOpen()
                .chooseStartDate(startDay, startMonth, startYear)
                .chooseEndDate(endDay, endMonth, endYear)
                .openOccupancyConfiguration()
                .checkOccupancyConfigurationIsOpen()
                .setNumberOfAdultsTo(adults);
        for (int i = 0; i < children; i++) {
            Random rand = new Random();
            staysSteps.addChild()
                    .chooseChildAge(rand.nextInt(0, 18));
        }
        staysSteps.setRoomsTo(rooms)
                .submitOccupancyConfigurations()
                .clickOnSearchButton();
        Configuration.timeout = 1000;
        staysSteps
                .checkSearchResultsAreReady()
                .offerLocationCheck(dest)
                .offersSatisfyConfigs(adults, children, tripDuration);
    }

    @AfterMethod
    public void tearDown() {
        softAssert.assertAll();
        closeWebDriver();
    }
}
