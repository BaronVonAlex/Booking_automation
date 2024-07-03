package ge.tbc.tbcacademy.steps.common;

import ge.tbc.tbcacademy.pages.common.HeaderSection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static ge.tbc.tbcacademy.data.constants.UIConstants.*;


public class HeaderSectionSteps extends HelperSteps<HeaderSectionSteps> {
    HeaderSection headerSection = new HeaderSection();

    @Step("Click on Register button.")
    public HeaderSectionSteps clickOnRegisterBtn() {
        headerSection.registerBtn.click();
        return this;
    }

    @Step("Click on Login button.")
    public HeaderSectionSteps clickSingInButton() {
        headerSection.loginBtn.click();
        return this;
    }

    @Step("Click on language flag")
    public HeaderSectionSteps clickLanguageFlag() {
        headerSection.languageBtn.click();
        if (headerSection.languages.get(0).is(not(visible))) {
            headerSection.languageBtn.click();
        }
        return this;
    }

    @Step("Choose flag for language '{0}'")
    public HeaderSectionSteps chooseFlag(String language) {
        headerSection.languages.findBy(exactText(language)).click();
        headerSection.bookingHomeHeader.shouldBe(visible);
        return this;
    }

    @Step("Navigate to Flights Page.")
    public HeaderSectionSteps navigateToFlightPage() {
        headerSection.flightsBtn.click();
        return this;
    }

    @Step("Navigate to Car Rental Page.")
    public HeaderSectionSteps navigateToCarRentalPage() {
        headerSection.carRental.click();
        return this;
    }

    @Step("Click the navigation item with the text '{0}'")
    public HeaderSectionSteps clickNavItemByText(String itemText) {
        headerSection.navbarItems.filterBy(text(itemText)).first().click();
        return this;
    }

    @Step("Validate header logo's ARIA label")
    public HeaderSectionSteps validateHeaderLogoAriaLabel() {
        validateElementValue(headerSection.headerLogo, ATTRIBUTE_ARIA_LABEL, BOOKING_ATTR_VAL);
        return this;
    }

    @Step("Validate change currency button's ARIA label")
    public HeaderSectionSteps validateChangeCurrencyBtnAriaLabel() {
        validateElementValue(headerSection.changeCurrencyBtn, ATTRIBUTE_ARIA_LABEL, CURRENCY_BTN_ATR_VAL);
        return this;
    }

    @Step("Validate if register button exists")
    public HeaderSectionSteps validateRegisterBtnExists() {
        validateIfElementExists(headerSection.registerBtn);
        return this;
    }

    @Step("Validate if login button exists")
    public HeaderSectionSteps validateLoginBtnExists() {
        validateIfElementExists(headerSection.loginBtn);
        return this;
    }

    @Step("Validate if change language button exists")
    public HeaderSectionSteps validateChangeLangBtnExists() {
        validateIfElementExists(headerSection.changeLangBtn);
        return this;
    }

    @Step("Validate if flights button exists")
    public HeaderSectionSteps validateFlightsBtnExists() {
        validateIfElementExists(headerSection.flightsBtn);
        return this;
    }

    @Step("Validate if car rental button exists")
    public HeaderSectionSteps validateCarRentalBtnExists() {
        validateIfElementExists(headerSection.carRentalBtn);
        return this;
    }

    @Step("Validate if attractions button exists")
    public HeaderSectionSteps validateAttractionsBtnExists() {
        validateIfElementExists(headerSection.attractionsBtn);
        return this;
    }

    @Step("Validate if airport taxis button exists")
    public HeaderSectionSteps validateAirportTaxisBtnExists() {
        validateIfElementExists(headerSection.airportTaxisBtn);
        return this;
    }

    @Step("Validate header background color")
    public HeaderSectionSteps validateHeaderBackgroundColor() {
        validateElementColor(headerSection.headerBackground, HEADER_ELEMENT_BACKGROUND_CLR);
        return this;
    }


    @Step("Validate hover effect color change for register button")
    public HeaderSectionSteps validateHoverEffectColorChangeRegisterBtn() {
        validateHoverEffectColorChange(headerSection.registerBtn);
        return this;
    }

    @Step("Validate hover effect color change for login button")
    public HeaderSectionSteps validateHoverEffectColorChangeLoginBtn() {
        validateHoverEffectColorChange(headerSection.loginBtn);
        return this;
    }
}
