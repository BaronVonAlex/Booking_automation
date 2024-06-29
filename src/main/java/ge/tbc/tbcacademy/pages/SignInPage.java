package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {
    public SelenideElement
            singInPageText = $x("//h1[text()='Sign in or create an account']"),
            emailField = $x("//input[@type='email']"),
            continueWithEmailBtn = $x("//button[.//span[text()='Continue with email']]"),
            emailAlert = $("#username-note"),
            singInWithAppleBtn = $x("//a[@aria-label='Sign in with Apple']"),
            singInWithFacebookBtn = $x("//a[@aria-label='Sign in with Facebook']"),
            singInWithGoogleBtn = $x("//a[@aria-label='Sign in with Google']"),
            passwordField = $(".YyPS4CCyBc09wPIEDhf6"),
            signInButton = $x("//button[.//span[text()='Sign in']]"),
            incorrectPasswordText = $("#password-note"),
            forgottenPasswordBtn = $("button[data-ga-label='forgot password']"),
            forgottenPasswordText = $x("//h1[@class='osvS4MYxeSR4s9RPRMlw nw-step-header']"),
            sendResetLinkBtn = $("button[type='submit']").$(byText("Send reset link")),
            checkYourInboxText = $x("//h1[text()='Check your inbox']"),
            backToSignInBtn = $x("//button[.//span[text()='Back to sign-in']]");


}
