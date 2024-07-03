package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {
    public SelenideElement
            emailInputField = $("#username"),
            submitBtn = $x("//button[@type='submit']"),
            gmailErrorMessage = $("#username-note"),
            passwordInputField = $("#new_password"),
            confirmationPasswordInputField = $("#confirmed_password"),
            passwordErrorMessage = $("#new_password-note"),
            confirmPasswordErrorMessage = $("#confirmed_password-note");
}
