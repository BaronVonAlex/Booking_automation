package ge.tbc.tbcacademy.booking;

import ge.tbc.tbcacademy.config.ConfigTests;
import ge.tbc.tbcacademy.pages.CarRentalPage;
import ge.tbc.tbcacademy.pages.FlightsPage;
import ge.tbc.tbcacademy.pages.HomePage;
import ge.tbc.tbcacademy.pages.common.HeaderSection;
import ge.tbc.tbcacademy.steps.HomePageSteps;
import ge.tbc.tbcacademy.steps.RegistrationPageSteps;
import ge.tbc.tbcacademy.steps.common.HeaderSectionSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static ge.tbc.tbcacademy.data.UIConstants.*;

@Epic("User Interface Tests")
public class UITests extends ConfigTests {
    protected static HeaderSectionSteps headerSectionSteps;
    protected static HeaderSection headerSection;
    protected static RegistrationPageSteps registrationPageSteps;
    protected static HomePageSteps homePageSteps;
    protected static HomePage homePage;
    protected static FlightsPage flightsPage;
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
                .validateElementValue(headerSection.headerLogo, ATTRIBUTE_ARIA_LABEL, BOOKING_ATTR_VAL)
                .validateElementValue(headerSection.changeCurrencyBtn, ATTRIBUTE_ARIA_LABEL, CURRENCY_BTN_ATR_VAL)
                .validateIfElementExists(headerSection.registerBtn)
                .validateIfElementExists(headerSection.loginBtn)
                .validateIfElementExists(headerSection.changeLangBtn)
                .validateIfElementExists(headerSection.flightsBtn)
                .validateIfElementExists(headerSection.carRentalBtn)
                .validateIfElementExists(headerSection.attractionsBtn)
                .validateIfElementExists(headerSection.airportTaxisBtn)
                .validateElementColor(headerSection.headerBackground, HEADER_ELEMENT_BACKGROUND_CLR);
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Main Page UI Items")
    @Feature("Main Page Elements")
    @Description("Validate if all Items are present on Main Page, check if their attribute values and background colors are correct.")
    @Test(description = "Validate UI elements on MainPage", priority = 2)
    public void mainHomePage() {
        homePageSteps
                // Validate element values
                .validateElementValue(homePage.backgroundImage, ATTRIBUTE_SRC, BACKGROUND_IMG_SRC_VAL)
                .validateElementValue(homePage.inputField, ATTRIBUTE_PLACEHOLDER, HOME_INPUT_FIELD_ATR_VAL)

                // Validate element text
                .validateElementText(homePage.dateInputFieldText, CHECK_IN_TXT_VAL)
                .validateElementText(homePage.searchSubmitBtnText, SEARCH_TXT_VAL)
                .validateElementText(homePage.registerBtnText, REGISTER_TXT_VAL)
                .validateElementText(homePage.signInBtnText, SIGN_IN_TXT_VAL)

                // Validate element existence
                .validateIfElementExists(homePage.searchSubmitBtn)
                .validateIfElementExists(homePage.instantDiscountRegisterBtn)
                .validateIfElementExists(homePage.instantDiscountSignInBtn)
                .validateIfElementExists(homePage.exploreBtn)

                // Validate element color
                .validateElementColor(homePage.searchSubmitBtn, SEARCH_BTN_COLOR_VAL)
                .validateElementColor(homePage.instantDiscountRegisterBtn, INSTANT_DISCOUNT_LOG_AUTH_BTN_COLOR_VAL)
                .validateElementColor(homePage.instantDiscountSignInBtn, INSTANT_DISCOUNT_LOG_AUTH_BTN_COLOR_VAL)

                // Validate Element color change while hovering
                .validateHoverEffectColorChange(headerSection.registerBtn)
                .validateHoverEffectColorChange(headerSection.loginBtn)
                .validateHoverEffectColorChange(homePage.searchSubmitBtn)
                .validateHoverEffectColorChange(homePage.exploreBtn)
                .validateHoverEffectColorChange(homePage.instantDiscountSignInBtn)
                .validateHoverEffectColorChange(homePage.instantDiscountRegisterBtn);
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Flights Page UI Items")
    @Feature("Flight Page Elements")
    @Description("Validate if all Items are present on Flight Page, check if their attribute values and background colors are correct.")
    @Test(description = "Validate UI elements on MainPage", priority = 4)
    public void flightPageTests() {
        headerSectionSteps
                .navigateToFlightPage()
                // Validate element existence
                .validateIfElementExists(flightsPage.formSection)
                .validateIfElementExists(flightsPage.destinationFrom)
                .validateIfElementExists(flightsPage.switchDestinationsButton)
                .validateIfElementExists(flightsPage.destinationTo)
                .validateIfElementExists(flightsPage.datesField)
                .validateIfElementExists(flightsPage.submitButton)
                .validateIfElementExists(flightsPage.languageBtn)
                .validateIfElementExists(flightsPage.currencyBtn)

                // Validate element color
                .validateElementColor(flightsPage.headerBackground, HEADER_BACKGROUND_COLOR)
                .validateElementColor(flightsPage.submitBtnColor, SUBMIT_BUTTON_COLOR)
                .validateElementColor(flightsPage.backgroundDiv, BACKGROUND_DIV_COLOR)

                // Validate element text
                .validateElementText(flightsPage.flightsTitle, FLIGHTS_TITLE_TEXT)
                .validateElementText(flightsPage.submitButtonText, SUBMIT_BUTTON_TEXT)
                .validateElementText(flightsPage.originPlace, ORIGIN_PLACE_TEXT)

                // Validate element values
                .validateElementValue(flightsPage.destinationFromText, ATTRIBUTE_PLACEHOLDER, DESTINATION_FROM_PLACEHOLDER)
                .validateElementValue(flightsPage.destinationInput, ATTRIBUTE_PLACEHOLDER, DESTINATION_TO_PLACEHOLDER);
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Car Rental Page UI Items")
    @Feature("Car Rental Page Elements")
    @Description("Validate if all Items are present on Car Rental Page, check if their attribute values and background colors are correct.")
    @Test(description = "Validate UI elements on Car Rental Page", priority = 5)
    public void carRentalPageTests() {
        headerSectionSteps
                .navigateToCarRentalPage()
                // Validate element existence
                .validateIfElementExists(carRentalPage.pickUpLocationDiv)
                .validateIfElementExists(carRentalPage.pickUpDateButton)
                .validateIfElementExists(carRentalPage.pickUpDateSelect)
                .validateIfElementExists(carRentalPage.dropOffDate)
                .validateIfElementExists(carRentalPage.dropOffTime)
                .validateIfElementExists(carRentalPage.searchButton)
                .validateIfElementExists(carRentalPage.supplierList)
                .validateIfElementExists(carRentalPage.faqsList)
                .validateIfElementExists(carRentalPage.footer)
                .validateIfElementExists(carRentalPage.footerTopMenu)

                // Validate element color
                .validateElementColor(carRentalPage.pickUpDateButton, PICKUP_BTN_CLR)

                // Validate element text
                .validateElementText(carRentalPage.carRentalHeader, CAR_RENTAL_HEADER_TEXT)
                .validateElementText(carRentalPage.searchButton, SEARCH_BUTTON_TEXT)

                // Validate element values
                .validateElementValue(carRentalPage.pickupLocationTxt, ATTRIBUTE_FOR, PICK_UP_LOCATION_VAL);
    }
}
