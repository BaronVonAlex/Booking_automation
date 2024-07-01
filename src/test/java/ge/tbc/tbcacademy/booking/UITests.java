package ge.tbc.tbcacademy.booking;

import ge.tbc.tbcacademy.booking.config.ConfigTests;
import ge.tbc.tbcacademy.pages.CarRentalPage;
import ge.tbc.tbcacademy.pages.FlightsPage;
import ge.tbc.tbcacademy.pages.HomePage;
import ge.tbc.tbcacademy.pages.common.HeaderSection;
import ge.tbc.tbcacademy.steps.*;
import ge.tbc.tbcacademy.steps.common.HeaderSectionSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("User Interface Tests")
public class UITests extends ConfigTests {
    protected static HeaderSectionSteps headerSectionSteps;
    protected static HeaderSection headerSection;
    protected static RegistrationPageSteps registrationPageSteps;
    protected static HomePageSteps homePageSteps;
    protected static HomePage homePage;
    protected static MainPageSteps mainPageSteps;
    protected static FlightsPage flightsPage;
    protected static FlightsPageSteps flightsPageSteps;
    protected static CarRentalPageSteps carRentalPageSteps;
    protected static CarRentalPage carRentalPage;
    protected static SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        registrationPageSteps = new RegistrationPageSteps();
        headerSectionSteps = new HeaderSectionSteps();
        headerSection = new HeaderSection();
        homePageSteps = new HomePageSteps();
        homePage = new HomePage();
        flightsPage = new FlightsPage();
        carRentalPage = new CarRentalPage();
        softAssert = new SoftAssert();
        flightsPageSteps = new FlightsPageSteps();
        mainPageSteps = new MainPageSteps();
        carRentalPageSteps = new CarRentalPageSteps();
        registrationPageSteps.openBookingWebPage();
    }

    @Severity(SeverityLevel.MINOR)
    @Story("NavBar UI Items")
    @Feature("NavBar Elements")
    @Description("Validate if all Items are present on NavBar, check if their attribute values and background colors are correct.")
    @Test(description = "Validate UI elements on NavBar", priority = 1)
    public void headerUITests() {
        homePageSteps.closeSignInPopUp();
        headerSectionSteps
                .validateHeaderLogoAriaLabel()
                .validateChangeCurrencyBtnAriaLabel()
                .validateRegisterBtnExists()
                .validateLoginBtnExists()
                .validateChangeLangBtnExists()
                .validateFlightsBtnExists()
                .validateCarRentalBtnExists()
                .validateAttractionsBtnExists()
                .validateAirportTaxisBtnExists()
                .validateHeaderBackgroundColor()
                .validateHoverEffectColorChangeRegisterBtn();
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Main Page UI Items")
    @Feature("Main Page Elements")
    @Description("Validate if all Items are present on Main Page, check if their attribute values and background colors are correct.")
    @Test(description = "Validate UI elements on MainPage", priority = 2)
    public void mainHomePage() {
        mainPageSteps
                // Validate element values
                .validateIfBackgroundImageExists()
                .validateInputFieldPlaceholder()

                // Validate element text
                .validateDateInputFieldText()
                .validateSearchSubmitBtnText()
                .validateRegisterBtnText()
                .validateSignInBtnText()

                // Validate element existence
                .validateSearchSubmitBtnExists()
                .validateInstantDiscountRegisterBtnExists()
                .validateInstantDiscountSignInBtnExists()
                .validateExploreBtnExists()

                // Validate element color
                .validateSearchSubmitBtnColor()
                .validateInstantDiscountRegisterBtnColor()
                .validateInstantDiscountSignInBtnColor()

                // Validate element color change while hovering
                .validateHoverEffectColorChangeSearchSubmitBtn()
                .validateHoverEffectColorChangeExploreBtn()
                .validateHoverEffectColorChangeInstantDiscountSignInBtn()
                .validateHoverEffectColorChangeInstantDiscountRegisterBtn();
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Flights Page UI Items")
    @Feature("Flight Page Elements")
    @Description("Validate if all Items are present on Flight Page, check if their attribute values and background colors are correct.")
    @Test(description = "Validate UI elements on Flight Page", priority = 4)
    public void flightPageTests() {
        headerSectionSteps
                .navigateToFlightPage();
        flightsPageSteps
                // Validate element existence
                .validateFormSectionExists()
                .validateDestinationFromExists()
                .validateSwitchDestinationsButtonExists()
                .validateDestinationToExists()
                .validateDatesFieldExists()
                .validateSubmitButtonExists()
                .validateLanguageButtonExists()
                .validateCurrencyButtonExists()

                // Validate element color
                .validateHeaderBackgroundColor()
                .validateSubmitButtonColor()
                .validateBackgroundDivColor()

                // Validate element text
                .validateFlightsTitleText()
                .validateSubmitButtonText()
                .validateOriginPlaceText()

                // Validate element values
                .validateDestinationFromPlaceholder()
                .validateDestinationToPlaceholder();
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Car Rental Page UI Items")
    @Feature("Car Rental Page Elements")
    @Description("Validate if all Items are present on Car Rental Page, check if their attribute values and background colors are correct.")
    @Test(description = "Validate UI elements on Car Rental Page", priority = 5)
    public void carRentalPageTests() {
        headerSectionSteps
                .navigateToCarRentalPage();
        carRentalPageSteps
                // Validate element existence
                .validatePickUpLocationDivExists()
                .validatePickUpDateButtonExists()
                .validatePickUpDateSelectExists()
                .validateDropOffDateExists()
                .validateDropOffTimeExists()
                .validateSearchButtonExists()
                .validateSupplierListExists()
                .validateFaqsListExists()
                .validateFooterExists()
                .validateFooterTopMenuExists()

                // Validate element color
                .validatePickUpDateButtonColor()

                // Validate element text
                .validateCarRentalHeaderText()
                .validateSearchButtonText()

                // Validate element values
                .validatePickUpLocationTextValue();
    }
}
