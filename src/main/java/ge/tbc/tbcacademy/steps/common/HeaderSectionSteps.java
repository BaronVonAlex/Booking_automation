package ge.tbc.tbcacademy.steps.common;

import ge.tbc.tbcacademy.pages.common.HeaderSection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;


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
}
