package ge.tbc.tbcacademy.booking;

import ge.tbc.tbcacademy.config.ConfigTests;
import ge.tbc.tbcacademy.pages.HomePage;
import ge.tbc.tbcacademy.pages.common.HeaderSection;
import ge.tbc.tbcacademy.steps.HomePageSteps;
import ge.tbc.tbcacademy.steps.RegistrationPageSteps;
import ge.tbc.tbcacademy.steps.common.HeaderSectionSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.tbcacademy.data.UIConstants.*;

@Epic("User Interface Tests")
public class UITests extends ConfigTests {
    protected static HeaderSectionSteps headerSectionSteps;
    protected static HeaderSection headerSection;
    protected static RegistrationPageSteps registrationPageSteps;
    protected static HomePageSteps homePageSteps;
    protected static HomePage homePage;

    @BeforeClass
    public void setUp() {
        registrationPageSteps = new RegistrationPageSteps();
        headerSectionSteps = new HeaderSectionSteps();
        headerSection = new HeaderSection();
        homePageSteps = new HomePageSteps();
        homePage = new HomePage();
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
    @Story("MainPage UI Items")
    @Feature("MainPage Elements")
    @Description("Validate if all Items are present on MainPage, check if their attribute values and background colors are correct.")
    @Test(description = "Validate UI elements on MainPage", priority = 2)
    public void mainHomePage() {
        homePageSteps
                .validateElementValue(homePage.backgroundImage, ATTRIBUTE_SRC, BACKGROUND_IMG_SRC_VAL)
                .validateElementValue(homePage.inputField, ATTRIBUTE_PLACEHOLDER, HOME_INPUT_FIELD_ATR_VAL)
                .validateIfElementExists(homePage.searchSubmitBtn)
                .validateElementColor(homePage.searchSubmitBtn, SEARCH_BTN_COLOR_VAL)
                .validateIfElementExists(homePage.instantDiscountRegisterBtn)
                .validateElementColor(homePage.instantDiscountRegisterBtn, INSTANT_DISCOUNT_LOG_AUTH_BTN_COLOR_VAL)
                .validateIfElementExists(homePage.instantDiscountSignInBtn)
                .validateElementColor(homePage.instantDiscountSignInBtn, INSTANT_DISCOUNT_LOG_AUTH_BTN_COLOR_VAL)
                .validateIfElementExists(homePage.exploreBtn);
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Valide Element behavior on Hover.")
    @Feature("Stays' Page Elements")
    @Description("Hover over elements and validate if color changes.")
    @Test(description = "Validate Color change on element hover", priority = 3)
    public void hoverOverElementTests() {
        headerSectionSteps
                .validateHoverEffectColorChange(headerSection.registerBtn)
                .validateHoverEffectColorChange(headerSection.loginBtn)
                .validateHoverEffectColorChange(homePage.searchSubmitBtn)
                .validateHoverEffectColorChange(homePage.exploreBtn)
                .validateHoverEffectColorChange(homePage.instantDiscountSignInBtn)
                .validateHoverEffectColorChange(homePage.instantDiscountRegisterBtn);
    }
}
