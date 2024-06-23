package ge.tbc.tbcacademy.booking;

import ge.tbc.tbcacademy.config.ConfigTests;
import ge.tbc.tbcacademy.steps.booking.BookingHomeSteps;
import ge.tbc.tbcacademy.steps.booking.BookingRegistrationSteps;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static ge.tbc.tbcacademy.data.Constants.*;

@Epic("Functionality and UI tests of Booking.com")
@Feature("Validation of critical functions: User Reg/Auth, Filter, Pagination.")
public class BookingTests extends ConfigTests {
    protected static BookingHomeSteps bookingHomeSteps;
    protected static BookingRegistrationSteps bookingRegistrationSteps;
    protected static HelperSteps helperSteps;
    private SoftAssert softAssert; // temporary solution.

    @BeforeTest
    public void setUp(){
        bookingHomeSteps = new BookingHomeSteps();
        bookingRegistrationSteps = new BookingRegistrationSteps();
        helperSteps = new HelperSteps();
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void setUpWebsite(){
        helperSteps.openBookingWebPage();
    }

    @Story("Validate Registration Process")
    @Test(description = "Navigate to Registration Page, Input different type of Mails and Passwords, then validate if appropriate message pops up. Register account and validate if account was created.")
    public void registrationTests() {
        bookingHomeSteps.clickOnRegisterBtn();
        bookingRegistrationSteps
                .inputMailAddress(INVALID_MAIL_FORMAT)
                .clickOnSubmitBtn();
        Assert.assertEquals(bookingRegistrationSteps.getIncorrectMailMsg(), INVALID_MAIL_FORMAT_ERR_MSG);

        bookingRegistrationSteps
                .inputMailAddress(VALID_MAIL_FORMAT)
                .clickOnSubmitBtn()
                .inputPassword(PASSWORD_SHORT)
                .clickOnSubmitBtn();
        Assert.assertEquals(bookingRegistrationSteps.getPasswordErrMsgTxt(), SHORT_PASSWORD_ERR_MSG);

        bookingRegistrationSteps
                .inputPassword(PASSWORD_NUM)
                .clickOnSubmitBtn();
        Assert.assertEquals(bookingRegistrationSteps.getPasswordErrMsgTxt(), CHARACTERS_ONLY_PASSWORD_ERR_MSG);

        bookingRegistrationSteps
                .inputPassword(PASSWORD_WITHOUT_UPPER)
                .clickOnSubmitBtn();
        Assert.assertEquals(bookingRegistrationSteps.getPasswordErrMsgTxt(), PASSWORD_WITH_NO_UPPERCASE_ERR_MSG);

        bookingRegistrationSteps
                .inputPassword(VALID_PASSWORD)
                .inputConfirmationPassword(PASSWORD_WITHOUT_UPPER)
                .clickOnSubmitBtn();
        Assert.assertEquals(bookingRegistrationSteps.getUnmatchingPasswordErrMsgTxt(), PASSWORDS_DID_NOT_MATCH_ERR_MSG);

        bookingRegistrationSteps
                .inputPassword(VALID_PASSWORD)
                .inputConfirmationPassword(VALID_PASSWORD)
                .clickOnSubmitBtn();

        Assert.assertEquals(bookingHomeSteps.validateIfHomePageIsLoaded(), EXPECTED_WELCOME_POP_TXT);
        bookingHomeSteps.clickOnGotItButton();
    }

    @AfterTest
    public void tearDown(){
        softAssert.assertAll();
    }
}
