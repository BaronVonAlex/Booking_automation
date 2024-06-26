package ge.tbc.tbcacademy.booking;

import ge.tbc.tbcacademy.config.ConfigTests;
import ge.tbc.tbcacademy.steps.SignInSteps;
import ge.tbc.tbcacademy.steps.common.HeaderSectionSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("User Authentication and Sign-In")
@Feature("Multi-Method Sign-In Process")
public class SignInTests extends ConfigTests {
    HeaderSectionSteps headerSectionSteps;
    SignInSteps signInSteps;

    @BeforeClass
    public void beforeClass() {
        headerSectionSteps = new HeaderSectionSteps();
        signInSteps = new SignInSteps();
        signInSteps.openBookingWebPage();
    }

    @Story("Email Sign-In Process")
    @Description("Test email sign-in functionality, including validation of error messages for invalid inputs and the redirect functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test email sign-in functionality.",priority = 1)
    public void logInTest() {
        headerSectionSteps
                .closeSignInPopUp()
                .clickSingInButton();
        signInSteps
                .checkSingInText()
                .clickContinueWithEmailBtn()
                .verifyErrorText()
                .inputInvalidEmail()
                .verifyIncorrectEmailText()
                .clickAppleBtn()
                .checkRedirectApplePage()
                .clickFacebookBtn()
                .checkRedirectFacebookPage()
                .clickGoogleBtn()
                .checkRedirectGooglePage()
                .inputCorrectEmail()
                .clickContinueWithEmailBtn()
                .verifyPasswordField()
                .clickForgottenPassword()
                .checkForgottenPasswordPage()
                .clickSendResetLinkBtn()
                .checkYourInboxTextCheck()
                .clickBackToSignInBtn()
                .checkSingInText()
                .clickContinueWithEmailBtn()
                .inputIncorrectPassword()
                .clickSignInBtn()
                .checkIncorrectPasswordText();

    }


}
