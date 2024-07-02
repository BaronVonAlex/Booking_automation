package ge.tbc.tbcacademy.booking;

import ge.tbc.tbcacademy.booking.config.ConfigTests;
import ge.tbc.tbcacademy.steps.AttractionSteps;
import org.testng.annotations.Test;

public class AttractionTests extends ConfigTests {
    AttractionSteps attractionSteps = new AttractionSteps();
    @Test
    public void attractionsTest(){
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
