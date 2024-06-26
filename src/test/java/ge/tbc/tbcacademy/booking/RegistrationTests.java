package ge.tbc.tbcacademy.booking;

import com.codeborne.selenide.Selenide;
import ge.tbc.tbcacademy.config.ConfigTests;
import ge.tbc.tbcacademy.data.dataproviders.invalidPasswordDataProvide;
import ge.tbc.tbcacademy.pages.RegisterPage;
import ge.tbc.tbcacademy.steps.RegistrationPageSteps;
import ge.tbc.tbcacademy.steps.common.HeaderSectionSteps;
import io.qameta.allure.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.tbcacademy.data.RandomCredentials.*;
import static ge.tbc.tbcacademy.data.RegistrationConstants.*;

@Epic("User Registration")
public class RegistrationTests extends ConfigTests {
    protected static HeaderSectionSteps headerSectionSteps;
    protected static RegistrationPageSteps registrationPageSteps;
    protected static RegisterPage registerPage;

    @BeforeClass
    public void setUp() {
        headerSectionSteps = new HeaderSectionSteps();
        registrationPageSteps = new RegistrationPageSteps();
        registerPage = new RegisterPage();

        registrationPageSteps.openBookingWebPage();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Registration Flow")
    @Feature("User Registration")
    @Description("Navigate to Registration Page, Input different type of Mails, Validate if Input fields have proper Data-Validation.")
    @Test(description = "Mail address input validation.",
            priority = 1)
    public void registrationInputFieldTests() {
        headerSectionSteps
                .closeSignInPopUp()
                .clickOnRegisterBtn();
        registrationPageSteps
                .clearInputField(registerPage.emailInputField)
                .inputMailAddress(INVALID_MAIL_FORMAT)
                .clickOnSubmitBtn()
                .getIncorrectMailMsg(INVALID_MAIL_FORMAT_ERR_MSG)
                .clearInputField(registerPage.emailInputField)
                .inputMailAddress(VALID_MAIL_FORMAT)
                .clickOnSubmitBtn();
    }

    @Severity(SeverityLevel.NORMAL)
    @Feature("User Registration")
    @Story("Password Validation")
    @Description("Input different type of passwords, validate if password input fields have appropriate Data-Validation")
    @Test(description = "Password Input Data Validation.",
            dataProvider = "invalidPasswordData",
            dataProviderClass = invalidPasswordDataProvide.class,
            priority = 2)
    public void invalidPasswordDataValidationTests(String password, String expectedErrorMessage) {
        registrationPageSteps
                .inputPassword(password)
                .clickOnSubmitBtn()
                .validateIncorrectFormatPasswordFields(expectedErrorMessage);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Feature("User Registration")
    @Story("Password Confirmation and Anti-Bot Protection")
    @Description("Input non-matching passwords in pass/conf.pass field and validate functionality, try to register and check if Anti-Bot security is working.")
    @Test(description = "Matching passwords validation and Anti-Bot Protection.",
            priority = 3)
    public void matchingPasswordAndAntiBotTests() {
        registrationPageSteps
                .inputPassword(VALID_PASSWORD)
                .inputConfirmationPassword(PASSWORD_WITHOUT_UPPER)
                .clickOnSubmitBtn()
                .validateIfNonMatchingPasswordsShowErrMsg(PASSWORDS_DID_NOT_MATCH_ERR_MSG)
                .clearInputField(registerPage.passwordInputField)
                .inputPassword(VALID_PASSWORD)
                .clearInputField(registerPage.confirmationPasswordInputField)
                .inputConfirmationPassword(VALID_PASSWORD)
                .clickOnSubmitBtn()
                .validateRobotActions();
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
