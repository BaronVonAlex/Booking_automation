package ge.tbc.tbcacademy.booking;

import com.codeborne.selenide.Configuration;
import ge.tbc.tbcacademy.config.ConfigTests;
import ge.tbc.tbcacademy.data.TripDataProvider;
import ge.tbc.tbcacademy.steps.funcitonal.StaysPageSteps;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import ge.tbc.tbcacademy.steps.common.PopUpSteps;
import ge.tbc.tbcacademy.utils.Util;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.Random;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Epic("Functional Tests")
public class SearchTests extends ConfigTests {
    PopUpSteps popUpSteps = new PopUpSteps();
    StaysPageSteps staysSteps = new StaysPageSteps();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void dismissPopups() {
        HelperSteps.openBookingWebPage();
        Configuration.timeout = 10000;
        if (popUpSteps.geniusPopUpIsDisplayed()) {
            popUpSteps.dismissGeniusSaveUpPopUp();
        }
    }

    @Description("")
    @Feature("")
    @Story("")
    @Test(groups = "Search Bar Components", dataProvider = "destinationProvider", dataProviderClass = TripDataProvider.class)
    public void chooseDestination(String dest) {
        staysSteps.focusOnDestinationInput()
                .clickOnDestinationInput()
                .writeDestination(dest)
                .selectDestinationFromDropdown(dest);
    }

    @Description("")
    @Feature("")
    @Story("")
    @Test(groups = "Search Bar Components", dataProvider = "adultsCountProvider", dataProviderClass = TripDataProvider.class)
    public void addingAdultsTests(int adults) {
        int currentNumberOfAdults = staysSteps.openOccupancyConfiguration()
                .checkOccupancyConfigurationIsOpen()
                .setNumberOfAdultsTo(adults)
                .getNumberOfAdults();

        softAssert.assertEquals(currentNumberOfAdults, adults,
                "Number Of adult Occupants doesn't correspond to selected amount");
        staysSteps.submitOccupancyConfigurations();

    }

    @Description("")
    @Feature("")
    @Story("")
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
        Assert.assertEquals(currentNumberOfChildren, children, "Number Of Children Doesn't correspond To Selected amount");
        staysSteps.submitOccupancyConfigurations();

    }

    @Description("")
    @Feature("")
    @Story("")
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

    @Description("")
    @Feature("")
    @Story("")
    @Test(groups = "Search Bar Components")
            public void chooseRoomNumber() {
        int n = 4;
        staysSteps.openOccupancyConfiguration()
                .checkOccupancyConfigurationIsOpen()
                .setRoomsTo(n);
        Assert.assertEquals(staysSteps.getRoomCount(), n, "Rooms Dont Match");
        staysSteps.submitOccupancyConfigurations();
    }
    @Description("")
    @Feature("")
    @Story("")
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
