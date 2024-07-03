package ge.tbc.tbcacademy.booking;

import com.codeborne.selenide.Selenide;
import ge.tbc.tbcacademy.booking.config.ConfigTests;
import ge.tbc.tbcacademy.steps.HomePageSteps;
import ge.tbc.tbcacademy.steps.MyAccountPageSteps;
import ge.tbc.tbcacademy.steps.SignInSteps;
import ge.tbc.tbcacademy.steps.common.HeaderSectionSteps;
import io.qameta.allure.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("User Authentication and Sign-In")
public class SignInTests extends ConfigTests {
    HeaderSectionSteps headerSectionSteps;
    HomePageSteps homePageSteps;
    SignInSteps signInSteps;
    MyAccountPageSteps myAccountPageSteps;

    @BeforeClass
    public void beforeClass() {
        headerSectionSteps = new HeaderSectionSteps();
        signInSteps = new SignInSteps();
        homePageSteps = new HomePageSteps();
        myAccountPageSteps = new MyAccountPageSteps();
        signInSteps.openBookingWebPage();
    }

    @Test(description = "Test email sign-in functionality.", priority = 1)
    @Story("Email Sign-In Process")
    @Feature("Multi-Method Sign-In Process")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test email sign-in functionality, including validation of error messages for invalid inputs and the redirect functionality")
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
                .inputCorrectPassword()
                .clickSignInBtn();
    }

    @Test(description = "Validate If Sign In process was successful", priority = 2)
    @Story("Account Sign-in process")
    @Feature("Validate Account Sign-in process")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Navigate to Manage Personal Settings and check if authorized user has correct mail address.")
    public void validateIfAccountWasSignedIn() {
        homePageSteps
                .clickOnProfile()
                .clickOnManageAccount();

        myAccountPageSteps
                .clickOnManagePersonDetails()
                .validateMailAddress();
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
