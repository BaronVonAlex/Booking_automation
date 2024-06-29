package ge.tbc.tbcacademy.booking;

import ge.tbc.tbcacademy.config.ConfigTests;
import ge.tbc.tbcacademy.steps.axeCore.AxeCoreSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Booking.com Quality Assurance")
public class AccessibilityTests extends ConfigTests {
    AxeCoreSteps axeCoreSteps;

    @BeforeClass
    public void setUp() {
        axeCoreSteps = new AxeCoreSteps();
    }

    @Test(description = "Performs an accessibility audit on the booking web page")
    @Story("Accessibility Testing")
    @Feature("Booking.com Accessibility")
    @Severity(SeverityLevel.MINOR)
    @Description("This test performs an accessibility audit on the Booking.com website using the Axe-core library and generates a report")
    public void accessibilityTestWithAxeCore() {
        axeCoreSteps
                .openBookingWebPage()
                .runAxeCoreLibraryInBrowser()
                .getAxeCoreAccessibilityAuditResults()
                .generateReportFromJsonResults();
    }

}
