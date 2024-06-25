package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PopUps {
    //google account sign in popup
    public SelenideElement googleSignInPopup = $("#credentials-picker-container");
    public SelenideElement googleSignInPopUpX = googleSignInPopup.$("#close");

    // genius popup save money
    public SelenideElement geniusSignInPopUpXBtn = $x("//*[text()='Sign in, save money']/ancestor::div//button");
    public SelenideElement geniusSignInPopUp = $(withText("Sign in or register"));
}
