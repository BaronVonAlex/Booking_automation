package ge.tbc.tbcacademy.booking;

import ge.tbc.tbcacademy.booking.config.ConfigTests;
import ge.tbc.tbcacademy.steps.AttractionSteps;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class AttractionTests extends ConfigTests {
    AttractionSteps attractionSteps = new AttractionSteps();

    @Test
    @Feature("Attractions")
    @Story("Search for attractions in a specific destination")
    @Description("Test to search for attractions in Barcelona and verify that all results are at the same location.")
    @Severity(SeverityLevel.MINOR)
    public void attractionsTest() {
        attractionSteps
                .openBookingWebPage()
                .closeSignInPopUp();
        attractionSteps.goToAttractions()
                .checkPageIsLoaded()
                .clickOnDestinatoinInput()
                .enterInput("Barcelona")
                .selectOption("Barcelona")
                .clickOnSearch()
                .checkPageIsLoaded()
                .checkResultsAreReady()
                .allAttractionsShouldContainDest("Barcelona");
    }
}
