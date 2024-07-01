package ge.tbc.tbcacademy.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.tbcacademy.data.constants.SignInConstants;
import ge.tbc.tbcacademy.pages.SignInPage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;
import static ge.tbc.tbcacademy.data.constants.SignInConstants.*;
import static org.testng.Assert.assertTrue;


public class SignInSteps extends HelperSteps<SignInSteps> {
    SignInPage singInPage = new SignInPage();

    @Step("Verifies that the sign-in page text matches the expected text.")
    public SignInSteps checkSingInText() {
        singInPage.singInPageText.shouldHave(text(SignInConstants.SIGN_IN_PAGE_TEXT));
        return this;
    }

    @Step("Clicks the Continue with Email button on the sign-in page.")
    public SignInSteps clickContinueWithEmailBtn() {
        singInPage.continueWithEmailBtn.click();
        return this;
    }

    @Step("Verifies that the error message displayed matches the expected text for an empty email field.")
    public SignInSteps verifyErrorText() {
        singInPage.emailAlert.shouldHave(text(SignInConstants.SIGN_IN_WITH_EMPTY_FIELD));
        return this;
    }

    @Step("Inputs an invalid email into the email field on the sign-in page")
    public SignInSteps inputInvalidEmail() {
        singInPage.emailField.setValue(SignInConstants.INCORRECT_EMAIL);
        singInPage.emailField.clear();
        return this;
    }

    @Step("Verifies that the error message displayed matches the expected text for an incorrect email format.")
    public SignInSteps verifyIncorrectEmailText() {
        singInPage.emailAlert.shouldHave(Condition.anyOf(
                text(SIGN_IN_WITH_INCORRECT_EMAIL),
                text(SIGN_IN_WITH_INCORRECT_EMAIL_SECOND_VARIANT)));
        singInPage.emailField.clear();
        return this;
    }

    @Step("Clicks the Sign in with Apple button on the sign-in page.")
    public SignInSteps clickAppleBtn() {
        singInPage.singInWithAppleBtn.click();
        return this;
    }

    @Step("Switches to the new window and verifies that the URL contains the expected Apple sign-in URL.")
    public SignInSteps checkRedirectApplePage() {
        switchTo().window(1);
        assertTrue(url().contains(SignInConstants.APPLE_URL));
        switchTo().window(0);
        return this;

    }

    @Step("Clicks the Sign in with Facebook button on the sign-in page.")
    public SignInSteps clickFacebookBtn() {
        singInPage.singInWithFacebookBtn.click();
        return this;
    }

    @Step("Switches to the new window and verifies that the URL contains the expected Facebook sign-in URL.")
    public SignInSteps checkRedirectFacebookPage() {
        switchTo().window(1);
        assertTrue(url().contains(SignInConstants.FACEBOOK_URL));
        switchTo().window(0);
        return this;

    }

    @Step("Clicks the Sign in with Google button on the sign-in page.")
    public SignInSteps clickGoogleBtn() {
        singInPage.singInWithGoogleBtn.click();
        return this;

    }

    @Step("Switches to the new window and verifies that the URL contains the expected Google sign-in URL.")
    public SignInSteps checkRedirectGooglePage() {
        switchTo().window(1);
        assertTrue(url().contains(SignInConstants.GOOGLE_URL));
        switchTo().window(0);
        return this;
    }

    @Step("Refreshes the page and inputs the correct email.")
    public SignInSteps inputCorrectEmail() {
        WebDriverRunner.getWebDriver().navigate().refresh();
        singInPage.emailField.setValue(SignInConstants.CORRECT_EMAIL);
        return this;
    }

    @Step("Verifies that the password field is visible.")
    public SignInSteps verifyPasswordField() {
        singInPage.passwordField.shouldBe(visible);
        return this;
    }

    @Step("Inputs an incorrect password.")
    public SignInSteps inputIncorrectPassword() {
        singInPage.passwordField.setValue(SignInConstants.INCORRECT_PASSWORD);
        return this;
    }

    @Step("Clicks the sign-in button.")
    public SignInSteps clickSignInBtn() {
        singInPage.signInButton.click();
        return this;
    }

    @Step("Verifies that the incorrect password error message is displayed.")
    public SignInSteps checkIncorrectPasswordText() {
        singInPage.incorrectPasswordText.shouldHave(text(SignInConstants.SIGN_IN_WITH_INCORRECT_PASSWORD));
        return this;
    }

    @Step("Inputs the correct password.")
    public SignInSteps inputCorrectPassword() {
        singInPage.passwordField.setValue(SignInConstants.CORRECT_PASSWORD);
        return this;
    }

    @Step("Click the 'Forgotten your password?' button.")
    public SignInSteps clickForgottenPassword() {
        singInPage.forgottenPasswordBtn.click();
        return this;
    }

    @Step("Verify the forgotten password page is displayed.")
    public SignInSteps checkForgottenPasswordPage() {
        singInPage.forgottenPasswordText.shouldBe(visible).should(anyOf(
                text(SignInConstants.FORGOTTEN_PASSWORD_TEXT),
                text(FORGOTTEN_PASSWORD_TEXT_SECOND_VARIANT)));
        return this;
    }

    @Step("Click the 'Send reset link' button.")
    public SignInSteps clickSendResetLinkBtn() {
        singInPage.sendResetLinkBtn.click();
        return this;
    }

    @Step("Verify the 'Check your inbox' text is displayed.")
    public SignInSteps checkYourInboxTextCheck() {
        singInPage.checkYourInboxText.shouldHave(text("Check your inbox"));
        return this;
    }

    @Step("Click the 'Back to Sign In' button.")
    public SignInSteps clickBackToSignInBtn() {
        singInPage.backToSignInBtn.click();
        return this;
    }
}



